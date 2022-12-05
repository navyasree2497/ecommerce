package com.server.ecommerce.repository;

import com.server.ecommerce.entity.Product;
import com.server.ecommerce.entity.Seller;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.hibernate.loader.Loader.SELECT;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "SELECT * FROM products WHERE type= ?1 ;", nativeQuery = true)
    public List<Product> getProductsByType(String type);

}
