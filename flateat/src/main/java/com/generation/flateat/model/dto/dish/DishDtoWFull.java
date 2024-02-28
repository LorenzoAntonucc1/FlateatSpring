package com.generation.flateat.model.dto.dish;

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
public class DishDtoWFull extends DishDtoBase 
{
    private Integer id;
    private Set<DishToDelivery> deliveries;
}
