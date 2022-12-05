package com.server.ecommerce.repository;

import com.server.ecommerce.entity.Customer;
import com.server.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "SELECT * FROM customer WHERE name= ?1 ;", nativeQuery = true)
    public List<Customer> findCustomerByName(String userName);

}
