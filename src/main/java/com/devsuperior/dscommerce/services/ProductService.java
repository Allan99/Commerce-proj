package com.devsuperior.dscommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import com.devsuperior.dscommerce.services.exceptions.DatabaseException;
import com.devsuperior.dscommerce.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@Transactional(readOnly = true)
	public Page<ProductDTO> findAll(Pageable pageable) {
		Page<Product> products = repository.findAll(pageable);
		return products.map(p -> new ProductDTO(p));
	}

	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		Product product = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Resource not found."));
		return new ProductDTO(product);
	}

	@Transactional
	public ProductDTO update(Long id, ProductDTO dto) {
		try {
			Product entity = repository.getReferenceById(id);
			entity.setName(dto.getName());
			entity.setPrice(dto.getPrice());
			entity.setImgUrl(dto.getImgUrl());
			entity.setDescription(dto.getDescription());
			entity = repository.save(entity);
			return new ProductDTO(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Resource not found.");
		}
	}
	
	@Transactional
	public ProductDTO insert(ProductDTO dto) {
		Product entity = new Product();
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());
		entity.setImgUrl(dto.getImgUrl());
		entity.setDescription(dto.getDescription());
		entity = repository.save(entity);
		return new ProductDTO(entity);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if(!repository.existsById(id)) {
			throw new ResourceNotFoundException("Resource not found.");
		}
		
		try {
			repository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation exception.");
		}
	}
}
