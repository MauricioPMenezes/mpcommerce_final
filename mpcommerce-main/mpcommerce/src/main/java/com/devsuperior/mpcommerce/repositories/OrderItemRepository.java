package com.devsuperior.mpcommerce.repositories;


import com.devsuperior.mpcommerce.entities.Order;
import com.devsuperior.mpcommerce.entities.OrderItem;
import com.devsuperior.mpcommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {


}
