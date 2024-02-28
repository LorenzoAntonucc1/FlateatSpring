package com.generation.flateat.model.dto.dishtodelivery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class DishToDeliveryDtoWFull extends DishToDeliveryDtoR 
{
    private Integer id;   
    private double totalPrice;
}
