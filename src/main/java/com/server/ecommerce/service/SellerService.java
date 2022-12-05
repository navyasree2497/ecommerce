package com.server.ecommerce.service;

import com.server.ecommerce.entity.Customer;
import com.server.ecommerce.entity.Seller;
import com.server.ecommerce.entity.SellerDTO;
import com.server.ecommerce.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {
    @Autowired
    private SellerRepository repository;

    public Seller addSeller(Seller seller){
        return repository.save(seller);
    }

    public List<Seller> addSellers(List<Seller> sellers){
        return repository.saveAll(sellers);
    }

    public List<Seller> getSellers(){
        return repository.findAll();
    }

    public Seller getSellerById(int id){
        return repository.findById(id).orElse(null);
    }

    public List<SellerDTO> getSellersByProductId(int id){
        return repository.getSellersNative(id);
    }

    public List<Seller> findSellerByName(String userName){
        return repository.findSellerByName(userName);
    }

}
