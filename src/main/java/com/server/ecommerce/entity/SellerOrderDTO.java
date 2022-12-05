package com.server.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SellerOrderDTO{

    @Id
    private int id;
    private int product_id;
    private String product_name;
    private String created_time;
    private int quantity;
    private float order_price;
    private String shipping_info;
    private String status;
}