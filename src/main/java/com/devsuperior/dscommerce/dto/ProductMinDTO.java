package com.devsuperior.dscommerce.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.devsuperior.dscommerce.entities.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductMinDTO {
	
	private Long id;
	private String name;
	private Double price;
	private String imgUrl;
	
	public ProductMinDTO() {
		
	}

	public ProductMinDTO(Long id, String name, Double price, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.imgUrl = imgUrl;
	}
	
	public ProductMinDTO(Product entity) {
		super();
		id = entity.getId();
		name = entity.getName();
		price = entity.getPrice();
		imgUrl = entity.getImgUrl();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductMinDTO other = (ProductMinDTO) obj;
		return Objects.equals(id, other.id);
	}

}
