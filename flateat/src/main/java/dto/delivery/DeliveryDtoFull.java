package dto.delivery;

import java.util.Set;

import entities.DishToDelivery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DeliveryDtoFull extends DeliveryDtoBase 
{
    private Integer id;
    private String notes;
    private Set <DishToDelivery> dishesDeliveries;
    private double dishesPrice();
    private double riderRevenue();
    private double totalPrice();

}
