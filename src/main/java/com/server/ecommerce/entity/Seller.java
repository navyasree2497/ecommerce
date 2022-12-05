package com.server.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="id")

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Sellers")
public class Seller extends User{

    private String seller_location;
    private String rating;

//    @ManyToMany(mappedBy = "sellers", fetch = FetchType.LAZY)
////    @JsonBackReference
//    private Set<Product> products;
}
