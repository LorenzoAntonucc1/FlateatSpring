package com.generation.flateat.model.dto.restaurant;
import java.util.List;

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
public abstract class RestaurantDtoBase 
{
    private String name;
    private String imgUrl;
    private List<String> foodTypes;
}
