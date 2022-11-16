package com.server.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue
    private int id;
    private String  name;
    private String description;
    private String imagePath;
    private String videoPath;
    private String stock;
    private String rating;
    private String reviews;
}
