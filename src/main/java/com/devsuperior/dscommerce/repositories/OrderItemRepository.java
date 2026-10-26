package com.devsuperior.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dscommerce.entities.OrderItem;
import com.devsuperior.dscommerce.entities.OrderItemPk;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk>{

}
