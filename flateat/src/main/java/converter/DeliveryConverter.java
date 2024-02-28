package converter;

import org.springframework.stereotype.Service;

import dto.delivery.DeliveryDtoFull;
import dto.delivery.DeliveryDtoR;
import entities.Delivery;
import entities.DishToDelivery;

@Service
public class DeliveryConverter 
{
    public Delivery dtoRToDelivery(DeliveryDtoR dto)//R
    {
        return  Delivery
                .builder()
                .expected_arrival(dto.getExpected_arrival())
                .distance(dto.getDistance())
                .user(dto.getUser())
                .restaurant(dto.getRestaurant())
                .paymentMethod(dto.getPaymentMethod())
                .build();
    }

    public DeliveryDtoFull DeliveryToDtoFull(Delivery d) {
        return DeliveryDtoFull
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
                .totalPrice(calcTotalPrice(calcDishesPrice(d),calcRiderRevenue(calcDishesPrice(d))))
                .build();
    }

    private double calcDishesPrice(Delivery d) {
        double dishesPrice = 0.0;

        for (DishToDelivery dd : d.getDishesDeliveries()) 
            dishesPrice += dd.getDish().getPrice();
        
        return dishesPrice;
    }

    private double calcRiderRevenue(double dishesPrice) {
        double riderRevenue = dishesPrice * 0.1;

        return riderRevenue;
    }

    private double calcTotalPrice(double dishesPrice, double riderRevenue) {
        double totalPrice = dishesPrice + riderRevenue;

        return totalPrice;
    }

}
