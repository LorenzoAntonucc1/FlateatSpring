package com.generation.flateat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.generation.flateat.model.dto.menu.MenuDtoWFull;
import com.generation.flateat.model.dto.restaurant.RestaurantDtoWAlone;
import com.generation.flateat.model.dto.restaurant.RestaurantDtoWNoUser;
import com.generation.flateat.model.dtoservices.MenuConverter;
import com.generation.flateat.model.repositories.MenuRepository;

@RestController
public class MenuController 
{
    @Autowired
    MenuConverter conv;

    @Autowired
    MenuRepository repo;

    @GetMapping("/menu/{id}")
    public MenuDtoWFull getAllMenuById(@PathVariable Integer id) 
    {
        return  conv.menuToDtoWFull(repo.findById(id).get());
    }

    @GetMapping("/menu")
    public List<MenuDtoWFull> getAllRestaurants() 
    {
        return  repo.findAll()
               .stream()
               .map(e -> conv.menuToDtoWFull(e))
               .toList();
    }
}
