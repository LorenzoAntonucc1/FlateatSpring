package com.generation.flateat.model.dto.delivery;

import java.util.Set;

import com.generation.flateat.model.entities.DishToDelivery;

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
public class DeliveryDtoWFull extends DeliveryDtoBase 
{
    private Integer id;
    private String notes;
    private Set<DishToDelivery> dishesDeliveries;

    private double dishesPrice;
    private double riderRevenue;
    private double totalPrice;

}
