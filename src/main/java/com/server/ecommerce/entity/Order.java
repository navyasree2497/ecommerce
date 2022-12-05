package com.server.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="id")
@Entity
@NamedNativeQuery(
        name = "find_orders_by_product",
        query = "SELECT * FROM orders o",
        resultSetMapping = "order_dto"
)
@SqlResultSetMapping(
        name = "order_dto",
        classes = @ConstructorResult(
                targetClass = Order.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "created_time", type = String.class),
                        @ColumnResult(name = "quantity", type = Integer.class),
                        @ColumnResult(name = "order_price", type = Float.class),
                        @ColumnResult(name = "gift_wrap", type = Boolean.class)
                }
        )
)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Orders")
public class Order{

    @Id
    @GeneratedValue
    private int id;
    private int productId;
    private int sellerId;
    private int customerId;
    private String created_time;
    private int quantity;
    private float order_price;
    private boolean gift_wrap;
    private String status;
}