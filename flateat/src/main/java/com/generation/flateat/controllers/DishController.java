package com.generation.flateat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.generation.flateat.model.dto.dish.DishDtoWFull;
import com.generation.flateat.model.dtoservices.DishConverter;
import com.generation.flateat.model.entities.Dish;
import com.generation.flateat.model.repositories.DishRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class DishController 
{
    @Autowired
    DishRepository repo;

    @Autowired
    DishConverter conv;
    
    @GetMapping("/dish/{id}")
    @Operation(description = "Reads Specific Dish by its ID")
    @ApiResponses(value = {
        @ApiResponse
        (
            description = "Dish Found and Returned",
            responseCode = "200",
            useReturnTypeSchema = true,
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Dish.class))
        ),
        @ApiResponse
        (
            description = "Dish not Found",
            responseCode = "404",
            content = @Content(mediaType = "text")
        )
    })
    public ResponseEntity<?> getAllDishById(@PathVariable @Parameter(description = "ID > 0") Integer id) 
    {
        DishDtoWFull dish = conv.dishToDtoWFull(repo.findById(id).get());
        
        if(dish!=null)
            return new ResponseEntity<DishDtoWFull>(dish,HttpStatus.OK);
        
            return new ResponseEntity<String>("Dish|"+id+" not found",HttpStatus.NOT_FOUND);
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
