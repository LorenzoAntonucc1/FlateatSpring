package com.generation.flateat.model.dtoservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.flateat.model.dto.review.ReviewDtoRPost;
import com.generation.flateat.model.entities.Review;
import com.generation.flateat.model.repositories.RestaurantRepository;
import com.generation.flateat.model.repositories.UserRepository;

@Service
public class ReviewConverter 
{
    @Autowired
    UserRepository uRepo;

    @Autowired
    RestaurantRepository rRepo;

    public Review dtoToReview(ReviewDtoRPost dto)
    {
        return Review.builder()
                .id(dto.getId())
                .restaurantOfReview(dto.getRestaurantOfReview())
                .userOfReview(dto.getUserOfReview())
                .vote(dto.getVote())
                .note(dto.getNote())
                .build();
    }

    public Review dtoToReview(Review dto)
    {
        return Review.builder()
                .id(dto.getId())
                .restaurantOfReview(dto.getRestaurantOfReview())
                .userOfReview(dto.getUserOfReview())
                .vote(dto.getVote())
                .note(dto.getNote())
                .build();
    }

    public Review dtoToReviewFull(Review dto, Integer restaurantId, Integer userId)
    {
        return Review.builder()
                .id(dto.getId())
                .restaurantOfReview(rRepo.findById(restaurantId).get())
                .userOfReview(uRepo.findById(userId).get())
                .vote(dto.getVote())
                .note(dto.getNote())
                .build();
    }

    public ReviewDtoRPost reviewToDto(Review r)
    {
        return ReviewDtoRPost.builder()
                .id(r.getId())
                .restaurantOfReview(r.getRestaurantOfReview())
                .userOfReview(r.getUserOfReview())
                .vote(r.getVote())
                .note(r.getNote())
                .build();
    }
}
