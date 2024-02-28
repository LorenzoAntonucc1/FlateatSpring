package com.generation.flateat.model.dto.dishtodelivery;
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

public abstract class DishToDeliveryDtoBase 
{
    private int quantity;
}
