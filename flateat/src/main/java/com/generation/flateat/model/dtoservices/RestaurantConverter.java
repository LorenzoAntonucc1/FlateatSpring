package com.generation.flateat.model.dtoservices;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.flateat.model.dto.restaurant.RestaurantDtoR;
import com.generation.flateat.model.dto.restaurant.RestaurantDtoWAlone;
import com.generation.flateat.model.dto.restaurant.RestaurantDtoWFull;
import com.generation.flateat.model.entities.Restaurant;
import com.generation.flateat.model.entities.User;
import com.generation.flateat.model.repositories.UserRepository;

@Service
public class RestaurantConverter 
{
    @Autowired
    UserRepository repo;
    public Restaurant dtoToRestaurant (RestaurantDtoR dto)
    {
        return  Restaurant
                .builder()
                .name(dto.getName())
                .phone(dto.getPhone())
                .openingHour(dto.getOpeningH())
                .closingHour(dto.getClosingH())
                .imgUrl(dto.getImgUrl())
                .positionX(dto.getPositionX())
                .positionY(dto.getPositionY())
                .build();
    }

    public RestaurantDtoWFull restaurantToDtoWFull(Restaurant r, User u)
    {
        return  RestaurantDtoWFull
                .builder()
                .id(r.getId())
                .name(r.getName())
                .foodTypes(r.getFoodTypes())
                .imgUrl(r.getImgUrl())
                .openingH(r.getOpeningHour())
                .closingH(r.getClosingHour())
                .phone(r.getPhone())
                .isOpen(isOpenRest(r))
                .distance(calcDist(r, u))
                .maxDeliveryDistance(r.getMaxDeliveryDistance())
                .deliveryPricePerUnit(r.getDeliveryPricePerUnit())
                .build();
    }

    public RestaurantDtoWAlone restaurantToDtoWAlone (Restaurant r, User u)
    {
        return  RestaurantDtoWAlone
                .builder()
                .id(r.getId())
                .name(r.getName())
                .foodTypes(r.getFoodTypes())
                .imgUrl(r.getImgUrl())
                .isOpen(isOpenRest(r))
                .distance(calcDist(r, u))
                .build();
    }

    public boolean isOpenRest(Restaurant r) 
    {
        int currentHour = LocalTime.now().getHour();

        return currentHour >= r.getOpeningHour() && currentHour < r.getClosingHour();
    }

    public int calcDist(Restaurant r, User user) 
    {
        
        int userPositionX = user.getPositionX();
        int userPositionY = user.getPositionY();
    
        
        int deltaX = Math.abs(r.getPositionX() - userPositionX);
        int deltaY = Math.abs(r.getPositionY() - userPositionY);
    
        
        return (int) Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
    

    
}