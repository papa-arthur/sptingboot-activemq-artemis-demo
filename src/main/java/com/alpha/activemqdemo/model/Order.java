package com.alpha.activemqdemo.model;

import lombok.Data;

@Data
public class Order {
    private Long orderId;
    private String productName;
    private int quantity;
    private double price;
}
