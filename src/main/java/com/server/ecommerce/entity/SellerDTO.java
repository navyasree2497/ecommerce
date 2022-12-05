package com.server.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="id")
@Entity
@NamedNativeQuery(
        name = "find_sellers_product_id",
        query = "SELECT s.id, s.name, ps.price, ps.discount  FROM sellers s " +
                "INNER JOIN product_seller ps " +
                "ON ps.seller_id = s.id " +
                "WHERE ps.product_id = ?1",
        resultSetMapping = "seller_dto"
)
@SqlResultSetMapping(
        name = "seller_dto",
        classes = @ConstructorResult(
                targetClass = SellerDTO.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "name", type = String.class),
                        @ColumnResult(name = "price", type = Float.class),
                        @ColumnResult(name = "discount", type = Float.class)
                }
        )
)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SellerDTO {

    @Id
    private int id;
    private String name;
    float price;
    float discount;
}
