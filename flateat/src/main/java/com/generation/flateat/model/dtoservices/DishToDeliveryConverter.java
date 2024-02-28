package com.generation.flateat.model.dtoservices;


import org.springframework.stereotype.Service;

import com.generation.flateat.model.dto.dishtodelivery.DishToDeliveryDtoR;
import com.generation.flateat.model.dto.dishtodelivery.DishToDeliveryDtoWFull;
import com.generation.flateat.model.entities.DishToDelivery;


@Service
public class DishToDeliveryConverter 
{
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
        return  DishToDeliveryDtoWFull
                .builder()
                .quantity(dd.getQuantity())
                .id(dd.getId())
                .dish(dd.getDish())
                .delivery(dd.getDelivery())
                .price(getPrice(dd))
                .build();
    }
}
