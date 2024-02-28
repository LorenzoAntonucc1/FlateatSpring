package com.generation.flateat.model.dto.dishtodelivery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class DishToDeliveryDtoR extends DishToDeliveryDtoBase 
{
    public DishToDeliveryDtoR(){};
    private Integer id;
}
