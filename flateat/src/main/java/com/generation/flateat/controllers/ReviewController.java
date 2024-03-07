package com.generation.flateat.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.flateat.model.dto.review.ReviewDtoBase;
import com.generation.flateat.model.dto.review.ReviewDtoRPost;
import com.generation.flateat.model.dtoservices.ReviewConverter;
import com.generation.flateat.model.entities.Restaurant;
import com.generation.flateat.model.entities.Review;
import com.generation.flateat.model.repositories.RestaurantRepository;
import com.generation.flateat.model.repositories.ReviewRepository;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class ReviewController 
{
    @Autowired
    RestaurantRepository restaurantRepo;

    @Autowired
    ReviewRepository reviewRepo;

    @Autowired
    ReviewConverter conv;

    @GetMapping("/reviews")
    public List<Review> getAllReviews()
    {
        return reviewRepo.findAll().stream().map(e -> conv.dtoToReview(e)).toList();
    }

    public ReviewDtoBase getReviewById(@PathVariable Integer id)
    {
        return conv.reviewToDto(reviewRepo.findById(id).get());
    }
    
    @GetMapping("/reviews/{restaurantId}")
    @Operation(description = "Returns all Reviews of a specific Restaurant")
    public List<Review> getReviewsByRestaurant(@PathVariable Integer restaurantId)
    {
        Restaurant r = restaurantRepo.findById(restaurantId).get();
        Set<Review> list =  r.getReviews();
        return list.stream().toList();
        // List<Review> list = reviewRepo.findAll().stream().map(e -> conv.dtoToReview(e)).toList();
        // list = list.stream().filter(r -> r.getRestaurantOfReview().getId() == restaurantId).toList();
        // return list;
    }

    @PostMapping("/reviews")
    public Review addReview(@RequestBody ReviewDtoRPost r)
    {
        Review review = conv.dtoToReview(r);
        return reviewRepo.save(review);
    }

    @PostMapping("/reviews/{restaurantId}/{userId}")
    @Operation(description =  ("Allows a User to post a Review -> will be linked to Restaurant-User"))
    public Review addFullReview(@RequestBody Review r, @PathVariable Integer restaurantId, @PathVariable Integer userId)
    {
        Review rev = conv.dtoToReviewFull(r, restaurantId, userId);
        return reviewRepo.save(rev);
    }
}
