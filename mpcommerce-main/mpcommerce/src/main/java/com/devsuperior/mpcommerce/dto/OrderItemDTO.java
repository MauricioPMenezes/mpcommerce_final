package com.devsuperior.mpcommerce.dto;

import com.devsuperior.mpcommerce.entities.OrderItem;
import com.devsuperior.mpcommerce.entities.OrderStatus;
import com.devsuperior.mpcommerce.entities.Payment;
import com.devsuperior.mpcommerce.entities.User;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class OrderItemDTO {

    private Long productId;

    private String name;

    private Double price;

    private Integer quantity;

    private String imgUrl;

    public OrderItemDTO() {

    }

    public OrderItemDTO(Long productId, String name, Double price, Integer quantity, String imgUrl) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imgUrl = imgUrl;
    }
    public OrderItemDTO(OrderItem entity) {
        productId = entity.getProduct().getId();
        name = entity.getProduct().getName();
        price = entity.getPrice();
        quantity = entity.getQuantity();
        imgUrl = entity.getProduct().getImgUrl();
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getSubTotal(){
        return price*quantity;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
