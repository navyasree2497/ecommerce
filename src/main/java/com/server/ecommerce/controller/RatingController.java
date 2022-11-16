package com.server.ecommerce.controller;

import com.server.ecommerce.entity.Rating;
import com.server.ecommerce.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RatingController {

    @Autowired
    private RatingService service;

    @PostMapping("/addRating")
    public Rating addRating(@RequestBody Rating rating){
        return service.addRating(rating);
    }

    @PostMapping("/addRatings")
    public List<Rating> addRatings(@RequestBody List<Rating> ratings){
        return service.addRatings(ratings);
    }

}
