package com.server.ecommerce.controller;

import com.server.ecommerce.entity.Wishlist;
import com.server.ecommerce.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WishlistController {

    @Autowired
    private WishlistService service;

    @PostMapping("/addWishlist")
    public Wishlist addWishlist(@RequestBody Wishlist wishlist){
        return service.addWishlist(wishlist);
    }

}
