package com.devsuperior.dscommerce.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.dscommerce.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Query("select obj from Product obj "
			+ "where upper(obj.name) like upper(concat('%', :name, '%'))")
	Page<Product> searchByName(String name, Pageable pageable);
	
	@Query("SELECT prod FROM Product prod JOIN FETCH prod.categories")
	Page<Product> searchAllProductsWithCategories(Pageable pageable);
}
