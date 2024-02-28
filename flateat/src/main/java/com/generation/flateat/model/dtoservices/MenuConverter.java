package com.generation.flateat.model.dtoservices;

import org.springframework.stereotype.Service;

import com.generation.flateat.model.dto.menu.MenuDtoW;
import com.generation.flateat.model.entities.Menu;

@Service
public class MenuConverter {
    
    public Menu dtoToMenu(MenuDtoW dto) {
        return Menu
                .builder()
                .dishes(dto.getDishes())
                .restaurant(dto.getRestaurant())
                .build();
    }

    public MenuDtoW menuToDto(Menu menu) {
        return MenuDtoW.builder()
                .dishes(menu.getDishes())
                .restaurant(menu.getRestaurant())
                .build();
    }
}
