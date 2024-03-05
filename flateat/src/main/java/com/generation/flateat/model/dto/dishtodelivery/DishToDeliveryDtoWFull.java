package com.generation.flateat.model.dto.dishtodelivery;

import com.generation.flateat.model.entities.Delivery;
import com.generation.flateat.model.entities.Dish;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class DishToDeliveryDtoWFull extends DishToDeliveryDtoBase
{
    private double price;
    private Dish dish;
    private Delivery delivery;

    private Integer id;
}
