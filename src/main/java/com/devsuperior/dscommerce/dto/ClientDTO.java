package com.devsuperior.dscommerce.dto;

import java.util.Objects;

import com.devsuperior.dscommerce.entities.User;

public class ClientDTO {
	
	private Long id;
	private String name;
	
	public ClientDTO() {
		
	}

	public ClientDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public ClientDTO(User entity) {
		super();
		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		ClientDTO other = (ClientDTO) obj;
		return Objects.equals(id, other.id);
	}

	
}
