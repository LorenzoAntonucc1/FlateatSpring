package com.generation.flateat.model.dto.menu;

import java.util.Set;

import com.generation.flateat.model.entities.Dish;
import com.generation.flateat.model.entities.Restaurant;

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
public abstract class MenuDtoBase {

    private Set<Dish> dishes;
    private Restaurant restaurant;
}
