package com.generation.flateat.model.dtoservices;

import org.springframework.stereotype.Service;

import com.generation.flateat.model.dto.menu.MenuDtoR;
import com.generation.flateat.model.dto.menu.MenuDtoWFull;
import com.generation.flateat.model.entities.Menu;

@Service
public class MenuConverter 
{
    
    public Menu dtoRToMenu(MenuDtoR dto) 
    {
        return  Menu
                .builder()
                .dishes(dto.getDishes())
                .restaurant(dto.getRestaurant())
                .id(dto.getId())
                .build();
    }

    public MenuDtoWFull menuToDtoWFull (Menu menu) 
    {
        return  MenuDtoWFull
                .builder()
                .dishes(menu.getDishes())
                .restaurant(menu.getRestaurant())
                .id(menu.getId())
                .build();
    }
}
