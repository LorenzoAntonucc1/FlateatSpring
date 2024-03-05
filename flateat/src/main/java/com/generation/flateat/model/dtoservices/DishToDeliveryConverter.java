package com.generation.flateat.model.dtoservices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.flateat.model.dto.dishtodelivery.DishToDeliveryDtoR;
import com.generation.flateat.model.dto.dishtodelivery.DishToDeliveryDtoRPost;
import com.generation.flateat.model.dto.dishtodelivery.DishToDeliveryDtoWFull;
import com.generation.flateat.model.entities.Delivery;
import com.generation.flateat.model.entities.Dish;
import com.generation.flateat.model.entities.DishToDelivery;
import com.generation.flateat.model.repositories.DeliveryRepository;
import com.generation.flateat.model.repositories.DishRepository;


@Service
public class DishToDeliveryConverter 
{
    @Autowired
    DishRepository dRepo;

    @Autowired
    DeliveryRepository deliveryRepo;

    private double getPrice(DishToDelivery dishes)
    {
        double res = 0;

        for(DishToDelivery d : dishes.getDish().getDeliveries())
            res += d.getDish().getPrice(); // () + d.getDelivery().getRestaurant().getDeliveryPricePerUnit()
        
        res += (dishes.getDelivery().getRestaurant().getDeliveryPricePerUnit() * dishes.getQuantity());

        return res;
    }

    // public DishToDeliveryDtoR dishToDeliveryToDtoR(DishToDelivery dishToDelivery) 
    // {
    //     DishToDeliveryDtoR dtoR = new DishToDeliveryDtoR();
    //     dtoR.setId(dishToDelivery.getId());
    //     dtoR.setQuantity(dishToDelivery.getQuantity());
    //     return dtoR;
    // }

    // public DishToDeliveryDtoWFull dishToDeliveryToDtoFull(DishToDelivery dishToDelivery) 
    // {
    //     DishToDeliveryDtoWFull dtoFull = new DishToDeliveryDtoWFull();
    //     dtoFull.setId(dishToDelivery.getId());
    //     dtoFull.setQuantity(dishToDelivery.getQuantity());
    //     dtoFull.setTotalPrice(getTotalPrice(dishToDelivery));
    //     return dtoFull;
    // }

    // public DishToDelivery dtoBaseToDishToDelivery(DishToDeliveryDtoR dtoBase) 
    // {
    //     return DishToDelivery.builder()
    //             .quantity(dtoBase.getQuantity())
    //             .build();
    // }

    // public DishToDelivery dtoRToDishToDelivery(DishToDeliveryDtoR dtoR) 
    // {
    //     DishToDelivery dishToDelivery = dtoBaseToDishToDelivery(dtoR);
    //     dishToDelivery.setId(dtoR.getId());
    //     return dishToDelivery;
    // }

    // public DishToDelivery dtoFullToDishToDelivery(DishToDeliveryDtoWFull dtoFull) 
    // {
    //     DishToDelivery dishToDelivery = dtoBaseToDishToDelivery(dtoFull);
    //     dishToDelivery.setId(dtoFull.getId());
    //     return dishToDelivery;
    // }

    public DishToDelivery DtoRToDishToDelivery (DishToDeliveryDtoR dto)
    {
        return  DishToDelivery
                .builder()
                .quantity(dto.getQuantity())
                .id(dto.getId())
                .build();
    }

    public DishToDeliveryDtoWFull DtoRToDishToDelivery (DishToDelivery dd)
    {
        Dish d = dRepo.findById(dd.getDish().getId()).get();
        return  DishToDeliveryDtoWFull
                .builder()
                .quantity(dd.getQuantity())
                .id(dd.getId())
                .dish(d)
                .delivery(dd.getDelivery())
                .price(getPrice(dd))
                .build();
    }

    public DishToDelivery dishToDeliveryToPostToDelivery(DishToDeliveryDtoRPost dd)
    {
        Dish d = dRepo.findById(dd.getDish_id()).get();
        Delivery delivery = deliveryRepo.findById(dd.getDelivery_id()).get();

        return  DishToDelivery
                .builder()
                .quantity(dd.getQuantity())
                .dish((d))
                .delivery(delivery)
                .build();
    }
}
