package com.generation.flateat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.generation.flateat.model.dto.menu.MenuDtoWFull;
import com.generation.flateat.model.dtoservices.MenuConverter;
import com.generation.flateat.model.repositories.MenuRepository;

@RestController
public class MenuController 
{
    @Autowired
    MenuConverter conv;

    @Autowired
    MenuRepository repo;

    @GetMapping("/menu/{restaurantId}")
    public MenuDtoWFull getAllMenuById(@PathVariable Integer restaurantId) 
    {
        List<MenuDtoWFull> list = repo.findAll()
        .stream()
        .map(e -> conv.menuToDtoWFull(e))
        .toList();

        list = list.stream().filter(m -> m.getRestaurant().getId() == restaurantId).toList();
        return list.stream().findFirst().get();
    }
 // s
    @GetMapping("/menu")
    public List<MenuDtoWFull> getAllRestaurants() 
    {
        return  repo.findAll()
               .stream()
               .map(e -> conv.menuToDtoWFull(e))
               .toList();
    }
}
