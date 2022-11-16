package com.server.ecommerce.service;

import com.server.ecommerce.entity.Rating;
import com.server.ecommerce.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    @Autowired
    private RatingRepository repository;

    public Rating addRating(Rating seller){
        return repository.save(seller);
    }

    public List<Rating> addRatings(List<Rating> ratings){
        return repository.saveAll(ratings);
    }

    public List<Rating> getSellers(){
        return repository.findAll();
    }

    public Rating getSellerById(int id){
        return repository.findById(id).orElse(null);
    }
}
