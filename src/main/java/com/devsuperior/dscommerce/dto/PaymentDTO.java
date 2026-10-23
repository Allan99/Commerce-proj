package com.devsuperior.dscommerce.dto;

import java.time.Instant;
import java.util.Objects;

import com.devsuperior.dscommerce.entities.Payment;

public class PaymentDTO {
	
	private Long id;
	private Instant moment;
	
	public PaymentDTO() {
		
	}

	public PaymentDTO(Long id, Instant moment) {
		super();
		this.id = id;
		this.moment = moment;
	}
	
	public PaymentDTO(Payment entity) {
		super();
		this.id = entity.getId();
		this.moment = entity.getMoment();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
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
		PaymentDTO other = (PaymentDTO) obj;
		return Objects.equals(id, other.id);
	}
}
