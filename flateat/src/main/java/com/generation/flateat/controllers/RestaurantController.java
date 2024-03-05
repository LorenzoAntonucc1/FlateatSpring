package com.generation.flateat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.generation.flateat.model.dto.dish.DishDtoWFull;
import com.generation.flateat.model.dto.restaurant.RestaurantDtoWAlone;
import com.generation.flateat.model.dto.restaurant.RestaurantDtoWFull;
import com.generation.flateat.model.dto.restaurant.RestaurantDtoWFullAverage;
import com.generation.flateat.model.dto.restaurant.RestaurantDtoWNoUser;
import com.generation.flateat.model.dtoservices.RestaurantConverter;
import com.generation.flateat.model.entities.Dish;
import com.generation.flateat.model.entities.Restaurant;
import com.generation.flateat.model.repositories.RestaurantRepository;
import com.generation.flateat.model.repositories.UserRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

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
    @Operation(description = "Returns a specific Restaurant by its ID and all its properties")
    @ApiResponses(value = {
        @ApiResponse
        (
            description = "Restaurant Found and Returned",
            responseCode = "200",
            useReturnTypeSchema = true,
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Restaurant.class))
        ),
        @ApiResponse
        (
            description = "Restaurant not Found",
            responseCode = "404",
            content = @Content(mediaType = "text")
        )
    })
    public ResponseEntity<?> getAllRestaurantById(@PathVariable Integer id) 
    {
        RestaurantDtoWAlone restaurant = conv.restaurantToDtoWAlone(repo.findById(id).get());
        if(restaurant!=null)
        return new ResponseEntity<RestaurantDtoWAlone>(restaurant,HttpStatus.OK);
        
        return new ResponseEntity<String>("Restaurant|"+id+" not found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/restaurants")
    @Operation(description = "Returns a list of all Restaurants")
    public List<RestaurantDtoWNoUser> getAllRestaurants() 
    {
        return  repo.findAll()
               .stream()
               .map(e -> conv.restaurantToDtoWNoUser(e))
               .toList();
    }

    @GetMapping("/restaurants/user/{id}")
    @Operation(description = "Returns all Restaurants and their distance from a specific User")
    @ApiResponses(value = {
        @ApiResponse
        (
            description = "Restaurant Found and Returned",
            responseCode = "200",
            useReturnTypeSchema = true,
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Restaurant.class))
        ),
        @ApiResponse
        (
            description = "User not Found",
            responseCode = "404",
            content = @Content(mediaType = "text")
        )
    })
    public ResponseEntity<?> getAllRestaurantWithUserLogged(@PathVariable Integer id)
    {
        List<RestaurantDtoWFullAverage> list = repo.findAll()
        .stream()
        .map(e -> conv.restaurantToDtoWFullAverage(e, uRepo.findById(id).get()))
        .toList();
        if(list.size()!=0)
        return new ResponseEntity<List<RestaurantDtoWFullAverage>>(list,HttpStatus.OK);

        return new ResponseEntity<String>("User|"+id+" not found",HttpStatus.NOT_FOUND);
    }

    // @GetMapping("/restaurant/{restaurantId}/{userId}")
    // @Operation(description = "Returns a specific Restaurants and its distance from a specific User")
    // @ApiResponses(value = {
    //     @ApiResponse
    //     (
    //         description = "Restaurant and User found",
    //         responseCode = "200",
    //         useReturnTypeSchema = true,
    //         content = @Content(mediaType = "application/json", schema = @Schema(implementation = Restaurant.class))
    //     ),
    //     @ApiResponse
    //     (
    //         description = "Restaurant or User not found",
    //         responseCode = "404",
    //         content = @Content(mediaType = "text")
    //     )
    // })
    // public ResponseEntity<?> getRestaurantByUserId(@PathVariable Integer restaurantId, @PathVariable Integer userId) 
    // {
    //     RestaurantDtoWFull rest = conv.restaurantToDtoWFull(repo.findById(restaurantId).get(), uRepo.findById(userId).get());
    //     if(rest!=null)
    //     return new ResponseEntity<RestaurantDtoWFull>(rest,HttpStatus.OK);

    //     return new ResponseEntity<String>("User or Restaurant not found",HttpStatus.NOT_FOUND);
    // }


    @GetMapping("/restaurant/{restaurantId}/{userId}")
    public ResponseEntity<?> getReviews(@PathVariable Integer restaurantId, @PathVariable Integer userId) 
    {
        RestaurantDtoWFullAverage rest = conv.restaurantToDtoWFullAverage(repo.findById(restaurantId).get(), uRepo.findById(userId).get());
        if(rest!=null)
        return new ResponseEntity<RestaurantDtoWFullAverage>(rest,HttpStatus.OK);

        return new ResponseEntity<String>("User or Restaurant not found",HttpStatus.NOT_FOUND);
    }
}
