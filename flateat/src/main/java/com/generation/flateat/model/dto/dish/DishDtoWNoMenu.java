package com.generation.flateat.model.dto.dish;

import java.util.Set;

import com.generation.flateat.model.entities.DishToDelivery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class DishDtoWNoMenu extends DishDtoBase
{
    private Integer id;
    private Set<DishToDelivery> deliveries;
}
