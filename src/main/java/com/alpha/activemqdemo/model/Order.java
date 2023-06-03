package com.alpha.activemqdemo.model;

import lombok.Data;

@Data
public class Order {

    private String orderId;
    private String productName;
    private int quantity;
    private double price;
}
