package com.generation.flateat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.generation.flateat.model.dto.dish.DishDtoWFull;
import com.generation.flateat.model.dto.restaurant.RestaurantDtoWAlone;
import com.generation.flateat.model.dto.restaurant.RestaurantDtoWNoUser;
import com.generation.flateat.model.dtoservices.DishConverter;
import com.generation.flateat.model.repositories.DishRepository;

@RestController
public class DishController 
{
    @Autowired
    DishRepository repo;

    @Autowired
    DishConverter conv;
    
    @GetMapping("/dish/{id}")
    public DishDtoWFull getAllDishById(@PathVariable Integer id) 
    {
        return  conv.dishToDtoWFull(repo.findById(id).get());
    }

    @GetMapping("/dish")
    public List<DishDtoWFull> getAllDish() 
    {
        return  repo.findAll()
               .stream()
               .map(e -> conv.dishToDtoWFull(e))
               .toList();
    }
}
