package com.server.ecommerce.repository;

import com.server.ecommerce.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller,Integer> {
}
