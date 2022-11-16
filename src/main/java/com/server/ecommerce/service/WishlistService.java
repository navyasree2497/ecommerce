package com.server.ecommerce.service;

import com.server.ecommerce.entity.Wishlist;
import com.server.ecommerce.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {
    @Autowired
    private WishlistRepository repository;

    public Wishlist addWishlist(Wishlist wishlist){
        return repository.save(wishlist);
    }

    public List<Wishlist> addWishlists(List<Wishlist> wishlists){
        return repository.saveAll(wishlists);
    }

    public List<Wishlist> getWishlists(){
        return repository.findAll();
    }

    public Wishlist getWishlistById(int id){
        return repository.findById(id).orElse(null);
    }
}
