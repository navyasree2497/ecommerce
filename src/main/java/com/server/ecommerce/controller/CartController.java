package com.server.ecommerce.controller;

import com.server.ecommerce.entity.Cart;
import com.server.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService service;

    @PostMapping("/addCart")
    public Cart addCart(@RequestBody Cart cart){
        return service.addCart(cart);
    }

    @PostMapping("/addCarts")
    public List<Cart> addCarts(@RequestBody List<Cart> carts){
        return service.addCarts(carts);
    }

    @GetMapping("/Carts")
    public List<Cart> getAllCarts(){
        return service.getCarts();
    }

    @GetMapping("/Cart/{id}")
    public Cart findCartById (@PathVariable int id){
        return service.getCartById(id);
    }
}
