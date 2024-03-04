package com.generation.flateat.controllers;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.flateat.model.dto.dishtodelivery.DishToDeliveryDtoRPost;
import com.generation.flateat.model.dto.dishtodelivery.DishToDeliveryDtoWFull;
import com.generation.flateat.model.dtoservices.DishToDeliveryConverter;
import com.generation.flateat.model.entities.DishToDelivery;
import com.generation.flateat.model.repositories.DishToDeliveryRepository;



@RestController
@RequestMapping("/dishToDelivery")
public class DishToDeliveryController {

    @Autowired
    DishToDeliveryRepository repo;

    @Autowired
    DishToDeliveryConverter conv;

    @GetMapping("/all")
    public List<DishToDeliveryDtoWFull> getAllDishToDelivery() {
        return repo.findAll()
                .stream()
                .map(e -> conv.DtoRToDishToDelivery(e))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DishToDeliveryDtoWFull getDishToDeliveryById(@PathVariable Integer id) {
        return conv.DtoRToDishToDelivery(repo.findById(id).get());
    }

    @PostMapping
    public DishToDelivery addDishToDelivery(@RequestBody DishToDeliveryDtoRPost dishToDeliveryDto) 
    {
        DishToDelivery dishToDelivery = conv.dishToDeliveryToPostToDelivery(dishToDeliveryDto);
        dishToDelivery = repo.save(dishToDelivery);
        return dishToDelivery;
    }

    // @PutMapping("/{id}")
    // public DishToDeliveryDtoWFull updateDishToDelivery(@PathVariable Integer id, @RequestBody DishToDeliveryDtoWFull dishToDeliveryDto) 
    // {
    //     DishToDelivery existingDishToDelivery = repo.findById(id).orElse(null);
    //     if (existingDishToDelivery != null) {
    //         DishToDelivery updatedDishToDelivery = conv.dtoFullToDishToDelivery(dishToDeliveryDto);
    //         updatedDishToDelivery.setId(id);
    //         return conv.dishToDeliveryToDtoFull(repo.save(updatedDishToDelivery));
    //     }
    //     return null;
    // }
}
