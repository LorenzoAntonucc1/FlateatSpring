package com.generation.flateat.model.dto.restaurant;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class RestaurantDtoWAlone extends RestaurantDtoBase
{
    private Integer id;
    private int distance;
    private boolean isOpen;
}
