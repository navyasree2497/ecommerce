package com.server.ecommerce.service;

import com.server.ecommerce.entity.Cart;
import com.server.ecommerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository repository;

    public Cart addCart(Cart cart){
        return repository.save(cart);
    }

    public List<Cart> addCarts(List<Cart> carts){
        return repository.saveAll(carts);
    }

    public List<Cart> getCarts(){
        return repository.findAll();
    }

    public Cart getCartById(int id){
        return repository.findById(id).orElse(null);
    }
}
