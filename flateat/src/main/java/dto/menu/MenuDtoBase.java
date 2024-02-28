package dto.menu;

import java.util.Set;

import entities.Dish;
import entities.Restaurant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public abstract class MenuDtoBase {

    private Set<Dish> dishes;
    private Restaurant restaurant;
}
