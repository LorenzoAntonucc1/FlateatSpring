package com.generation.flateat.model.dto.review;

import com.generation.flateat.model.entities.User;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class ReviewDtoRPost extends ReviewDtoBase
{
    public ReviewDtoRPost(){}
    private User userOfReview;
}
