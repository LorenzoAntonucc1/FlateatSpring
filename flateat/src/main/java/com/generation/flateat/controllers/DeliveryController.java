package com.generation.flateat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.generation.flateat.model.dto.delivery.DeliveryDtoWFull;
import com.generation.flateat.model.dto.delivery.DeliveryDtoWNoTotalPrice;
import com.generation.flateat.model.dtoservices.DeliveryConverter;
import com.generation.flateat.model.repositories.DeliveryRepository;
import com.generation.flateat.model.repositories.RestaurantRepository;

@RestController
public class DeliveryController 
{
    @Autowired
    DeliveryRepository repo;

    @Autowired
    RestaurantRepository rRepo;

    @Autowired
    DeliveryConverter conv;
    
    @GetMapping("/delivery/{id}")
    public DeliveryDtoWNoTotalPrice getAllDeliveryById(@PathVariable Integer id) 
    {
        return  conv.DeliveryToDtoWNoTotalPrice(repo.findById(id).get());
    }

    @GetMapping("/delivery")
    public List<DeliveryDtoWNoTotalPrice> getAllDelivery() 
    {
        return  repo.findAll()
               .stream()
               .map(e -> conv.DeliveryToDtoWNoTotalPrice(e))
               .toList();
    }

    @GetMapping("/delivery/{deliveryId}/{restaurantId}")
    public DeliveryDtoWFull getDeliveryByRestaurantId(@PathVariable Integer deliveryId, @PathVariable Integer restaurantId) 
    {
        return conv.DeliveryToDtoWFull(repo.findById(deliveryId).get(), rRepo.findById(restaurantId).get());
    }
}

