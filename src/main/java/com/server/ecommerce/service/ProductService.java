package com.server.ecommerce.service;

import com.server.ecommerce.entity.Product;
import com.server.ecommerce.entity.Seller;
import com.server.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product addProduct(Product product){
        return repository.save(product);
    }

    public List<Product> addProducts(List<Product> products){
        return repository.saveAll(products);
    }

    public List<Product> getProducts(){
        return repository.findAll();
    }
    public List<Product> getProductsByType(String type){
        return repository.getProductsByType(type);
    }

    public List<Seller> getProductSellers(Integer id){
        System.out.println(id);
//        System.out.println(repository.getProductSellers(id));
//        System.out.println(repository.findBySellers_id(id));

        return null;
    }

    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }

}
