package com.generation.flateat.model.dto.dish;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class DishDtoR extends DishDtoBase
{
    public DishDtoR(){};
    private Integer id;
}
