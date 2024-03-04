package com.generation.flateat.model.dto.review;

import com.generation.flateat.model.entities.Restaurant;
import com.generation.flateat.model.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ReviewDtoBase 
{
    private Integer id;
    private int vote;
    private String note;

    private User userOfReview;
    private Restaurant restaurantOfReview;
}
