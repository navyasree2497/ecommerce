package com.server.ecommerce.controller;

import com.server.ecommerce.entity.Product;
import com.server.ecommerce.entity.Seller;
import com.server.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    @CrossOrigin
    public Product addProduct(@RequestBody Product product){
        return service.addProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return service.addProducts(products);
    }

    @GetMapping("/products/{type}")
    @CrossOrigin
    public List<Product> getProductsByType(@PathVariable String type){
        return service.getProductsByType(type);
    }

//    @GetMapping("/products/getSellers/{productId}")
//    @CrossOrigin
//    public List<Seller> getProductSellers(@PathVariable int productId){
//        System.out.println(productId);
//        return service.getProductSellers(productId);
//    }

//    @GetMapping("/product/{id}")
//    public Product findProductById (@PathVariable int id){
//        return service.getProductById(id);
//    }
}
