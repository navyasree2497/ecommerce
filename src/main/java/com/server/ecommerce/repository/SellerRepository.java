package com.server.ecommerce.repository;

import com.server.ecommerce.entity.Customer;
import com.server.ecommerce.entity.Seller;
import com.server.ecommerce.entity.SellerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SellerRepository extends JpaRepository<Seller,Integer> {

    @Query(name = "find_sellers_product_id", nativeQuery = true)
    List<SellerDTO> getSellersNative(Integer pid);

    @Query(value = "SELECT * FROM sellers WHERE name= ?1 ;", nativeQuery = true)
    public List<Seller> findSellerByName(String userName);
}
