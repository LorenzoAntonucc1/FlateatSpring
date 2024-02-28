package converter;

import org.springframework.stereotype.Service;

import dto.dish.DishDtoWFull;
import entities.Dish;

@Service
public class DishConverter 
{
    public Dish dtoToDish(DishDtoWFull dto)
    {
        return Dish
                .builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .category(dto.getCategory())
                .ingredients(dto.getIngredients())
                .build();
    }

    public DishDtoWFull dishToDto(Dish dish)
    {
        return DishDtoWFull
                .builder()
                .name(dish.getName())
                .price(dish.getPrice())
                .category(dish.getCategory())
                .ingredients(dish.getIngredients())
                .build();
    }
    
}
