package com.server.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="id")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class Product{

    @Id
    @GeneratedValue
    private int id;
    private String  name;
    private Float price;
    private String description;
    private String imagePath;
    private String videoPath;
    private String stock;
    private String rating;
    private String reviews;
    private String type;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "product_orders",
//            joinColumns = {
//                    @JoinColumn(name = "product_id", referencedColumnName = "id")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "order_id", referencedColumnName = "id")
//            })
////    @JsonManagedReference
//    private Set<Order> orders;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "product_seller",
//    joinColumns = {
//            @JoinColumn(name = "product_id", referencedColumnName = "id")
//    },
//    inverseJoinColumns = {
//            @JoinColumn(name = "seller_id", referencedColumnName = "id")
//    })
////    @JsonManagedReference
//    private Set<Seller> sellers;
}
