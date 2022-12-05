package com.server.ecommerce.repository;

import com.server.ecommerce.entity.Order;
import com.server.ecommerce.entity.OrderDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {

//    @Query(name = "find_orders_by_product", nativeQuery = true)
//    List<Order> getAllOrdersNative();
//
//    @Query(name = "find_orders_by_product_2", nativeQuery = true)
//    List<OrderDTO> getAllOrdersNativeDTO();
}
