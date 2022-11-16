package com.server.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Rating")
public class Rating{

    @Id
    @GeneratedValue
    private int id;
    private int productId;
    private int customerId;
    private float rating;
    private String review;
}
