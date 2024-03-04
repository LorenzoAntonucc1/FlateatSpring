package com.generation.flateat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.flateat.model.dto.menu.MenuDtoWFull;
import com.generation.flateat.model.dto.review.ReviewDtoBase;
import com.generation.flateat.model.dto.review.ReviewDtoRPost;
import com.generation.flateat.model.dtoservices.ReviewConverter;
import com.generation.flateat.model.entities.Review;
import com.generation.flateat.model.repositories.RestaurantRepository;
import com.generation.flateat.model.repositories.ReviewRepository;

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
    public List<Review> getReviewsByRestaurant(@PathVariable Integer restaurantId)
    {
        List<Review> list = reviewRepo.findAll().stream().map(e -> conv.dtoToReview(e)).toList();
        list = list.stream().filter(r -> r.getRestaurantOfReview().getId() == restaurantId).toList();
        return list;
    }

    @PostMapping("/reviews")
    public Review addReview(@RequestBody ReviewDtoRPost r)
    {
        Review review = conv.dtoToReview(r);
        return reviewRepo.save(review);
    }
}
