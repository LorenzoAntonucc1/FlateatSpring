package com.generation.flateat.model.dto.delivery;

import java.time.LocalDateTime;

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
public abstract class DeliveryDtoBase 
{

    private LocalDateTime expected_arrival;
    private int distance;
    private User user;
    private Restaurant restaurant;  
    private String paymentMethod; 

}
