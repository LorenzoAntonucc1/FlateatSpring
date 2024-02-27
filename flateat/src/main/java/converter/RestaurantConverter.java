package converter;

import java.time.LocalTime;

import dto.restaurant.RestaurantDtoWsec;
import entities.Restaurant;

public class RestaurantConverter 
{
    public Restaurant dtoToRestaurant (RestaurantDtoWsec dto)
    {
        return Restaurant
                .builder()
                .name(dto.getName())
                .foodTypes(dto.getFoodTypes())
                .openingHour(dto.getOpeningH())
                .closingHour(dto.getClosingH())
                .imgUrl(dto.getImgUrl())
                .build();
    }
    public RestaurantDtoWsec restaurantToDto(Restaurant r)
    {
        return RestaurantDtoWsec
                .builder()
                .name(r.getName())
                .foodTypes(r.getFoodTypes())
                .imgUrl(r.getImgUrl())
                .openingH(r.getOpeningHour())
                .closingH(r.getClosingHour())
                .phone(r.getPhone())
                .isOpen(isOpenRest(r))
                .distanza(0)
                .build();
    }

    public boolean isOpenRest(Restaurant r) 
    {
        int currentHour = LocalTime.now().getHour();

        return currentHour >= r.getOpeningHour() && currentHour < r.getClosingHour();
    }

    public int calcDist(Restaurant r)
    {

    }

    
}