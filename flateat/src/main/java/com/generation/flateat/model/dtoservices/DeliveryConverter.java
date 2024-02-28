package com.generation.flateat.model.dtoservices;

import org.springframework.stereotype.Service;

import com.generation.flateat.model.dto.delivery.DeliveryDtoWFull;
import com.generation.flateat.model.dto.delivery.DeliveryDtoWNoTotalPrice;
import com.generation.flateat.model.dto.delivery.DeliveryDtoR;
import com.generation.flateat.model.dto.restaurant.RestaurantDtoWFull;
import com.generation.flateat.model.entities.Delivery;
import com.generation.flateat.model.entities.DishToDelivery;
import com.generation.flateat.model.entities.Restaurant;


@Service
public class DeliveryConverter 
{
    public Delivery dtoRToDelivery(DeliveryDtoR dto)//R
    {
        return  Delivery
                .builder()
                .id(dto.getId())
                .expected_arrival(dto.getExpected_arrival())
                .distance(dto.getDistance())
                .user(dto.getUser())
                .restaurant(dto.getRestaurant())
                .paymentMethod(dto.getPaymentMethod())
                .build();
    }

    public DeliveryDtoWFull DeliveryToDtoWFull(Delivery d, Restaurant r ) {
        return DeliveryDtoWFull
                .builder()
                .expected_arrival(d.getExpected_arrival())
                .distance(d.getDistance())
                .user(d.getUser())
                .restaurant(d.getRestaurant())
                .paymentMethod(d.getPaymentMethod())
                .id(d.getId())
                .notes(d.getNotes())
                .dishesDeliveries(d.getDishesDeliveries())
                .dishesPrice(calcDishesPrice(d))
                .riderRevenue(calcRiderRevenue(calcDishesPrice(d)))
                .totalPrice(calcTotalPrice(calcDishesPrice(d), r))
                .build();
    }

    public DeliveryDtoWNoTotalPrice DeliveryToDtoWNoTotalPrice(Delivery d) 
    {
        return  DeliveryDtoWNoTotalPrice
                .builder()
                .expected_arrival(d.getExpected_arrival())
                .distance(d.getDistance())
                .user(d.getUser())
                .restaurant(d.getRestaurant())
                .paymentMethod(d.getPaymentMethod())
                .id(d.getId())
                .notes(d.getNotes())
                .dishesDeliveries(d.getDishesDeliveries())
                .build();
    }

    private double calcDishesPrice(Delivery d) 
    {
        double dishesPrice = 0.0;

        for (DishToDelivery dd : d.getDishesDeliveries()) 
            dishesPrice += dd.getDish().getPrice();
        
        return dishesPrice;
    }

    private double calcRiderRevenue(double dishesPrice) 
    {
        double riderRevenue = dishesPrice * 0.1;

        return riderRevenue;
    }

    private double calcTotalPrice(double dishesPrice, Restaurant r) 
    {
        double totalPrice = dishesPrice + r.getDeliveryPricePerUnit();

        return totalPrice;
    }

}
