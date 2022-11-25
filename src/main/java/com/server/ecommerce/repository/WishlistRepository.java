package com.server.ecommerce.repository;

import com.server.ecommerce.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist,Integer> {
}
