package com.generation.flateat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.generation.flateat.model.dto.restaurant.RestaurantDtoWAlone;
import com.generation.flateat.model.dto.restaurant.RestaurantDtoWFull;
import com.generation.flateat.model.dtoservices.RestaurantConverter;
import com.generation.flateat.model.repositories.RestaurantRepository;
import com.generation.flateat.model.repositories.UserRepository;

@RestController
public class RestaurantController 
{

    @Autowired
    RestaurantRepository repo;
    
    @Autowired
    UserRepository uRepo;

    @Autowired
    RestaurantConverter conv;
    
    @GetMapping("/restaurants/{id}")
    public List<RestaurantDtoWAlone> getAllRestaurant(@PathVariable Integer id) 
    {
        return  repo.findAll()
               .stream()
               .map(e -> conv.restaurantToDtoWAlone(e,uRepo.findById(id).get()))
               .toList();
    }

    // @GetMapping("/restaurant/search")
    // public List<RestaurantDtoWsec> searchRestaurantByNameAndFoodType(@RequestParam String partialName,@RequestParam String foodType) 
    // {
    //     List<Restaurant> restaurantsByName = repo.findByNameContaining(partialName);
    //     List<Restaurant> restaurantsByFoodType = repo.findByFoodTypesContaining(foodType);

        
    //     List<Restaurant> intersection = restaurantsByName.stream()
    //             .filter(restaurantsByFoodType::contains)
    //             .collect(Collectors.toList());

    //     return intersection.stream()
    //             .map(conv::restaurantToDto)
    //             .collect(Collectors.toList());
    // }

    @GetMapping("/restaurant/{restuarantId}/{userId}")
    public RestaurantDtoWFull getRestaurantByUserId(@PathVariable Integer restuarantId, @PathVariable Integer userId) 
    {
        return conv.restaurantToDtoWFull(repo.findById(restuarantId).get(), uRepo.findById(userId).get());
    }
}
