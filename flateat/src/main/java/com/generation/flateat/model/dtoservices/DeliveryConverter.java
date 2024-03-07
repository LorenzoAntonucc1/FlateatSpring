package com.generation.flateat.model.dtoservices;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.flateat.model.dto.delivery.DeliveryDtoWFull;
import com.generation.flateat.model.dto.delivery.DeliveryDtoWNoTotalPrice;
import com.generation.flateat.model.dto.delivery.DeliveryToString;
import com.generation.flateat.model.dto.delivery.DeliveryDtoR;
import com.generation.flateat.model.entities.Delivery;
import com.generation.flateat.model.entities.DishToDelivery;
import com.generation.flateat.model.repositories.RestaurantRepository;
import com.generation.flateat.model.repositories.UserRepository;


@Service
public class DeliveryConverter 
{
    @Autowired
    UserRepository uRepo;

    @Autowired
    RestaurantRepository rRepo;

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

    public DeliveryDtoWFull DeliveryToDtoWFull(Delivery d) {
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
                .totalPrice(calcTotalPrice(calcDishesPrice(d), d))
                .build();
    }

    public Delivery delivToDto(DeliveryToString d, Integer restaurantId, Integer userId)
    {
        return Delivery
                .builder()
                .expected_arrival(swap(d.getExpected_arrival()))
                .distance(d.getDistance())
                .user(uRepo.findById(userId).get())
                .restaurant(rRepo.findById(restaurantId).get())
                .paymentMethod(d.getPaymentMethod())
                .id(d.getId())
                .notes(d.getNotes())
                .build();
    }

    public LocalDateTime swap(String date)
    {
        LocalDateTime res = LocalDateTime.now();
        String[] split = date.split(":");
        res = res.withHour(Integer.parseInt(split[0])).withMinute(Integer.parseInt(split[1]));
        return res;
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

    private double calcTotalPrice(double dishesPrice,Delivery d) 
    {
        double totalPrice = dishesPrice + d.getRestaurant().getDeliveryPricePerUnit();

        return totalPrice;
    }

}
