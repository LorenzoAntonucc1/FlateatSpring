package com.generation.flateat.model.dtoservices;

import org.springframework.stereotype.Service;

import com.generation.flateat.model.dto.review.ReviewDtoRPost;
import com.generation.flateat.model.entities.Review;

@Service
public class ReviewConverter 
{
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
