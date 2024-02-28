package com.generation.flateat.model.dto.dish;
import java.util.List;

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
public abstract class DishDtoBase 
{
    private String name;
    private double price;
    private String category;
    private List<String> ingredients;
}
