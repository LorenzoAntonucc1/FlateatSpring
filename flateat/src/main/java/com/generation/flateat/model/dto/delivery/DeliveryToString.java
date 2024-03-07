package com.generation.flateat.model.dto.delivery;

import java.util.Set;

import com.generation.flateat.model.entities.DishToDelivery;
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
public class DeliveryToString 
{
    private Integer id;
    private int distance;
    private String paymentMethod; 
    private String notes;

    private String expected_arrival;
    
    private User user;
    private Restaurant restaurant;  
}
