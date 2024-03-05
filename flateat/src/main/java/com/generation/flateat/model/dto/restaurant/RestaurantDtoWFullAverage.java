package com.generation.flateat.model.dto.restaurant;

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
public class RestaurantDtoWFullAverage extends RestaurantDtoBase
{
    private Integer id;
    private int distance;
    private int maxDeliveryDistance;
    private double deliveryPricePerUnit;
    private String phone;
    private int openingH;
    private int closingH;
    private boolean isOpen;
    private int average;
}
