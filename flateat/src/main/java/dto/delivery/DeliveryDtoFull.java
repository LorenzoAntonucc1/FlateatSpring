package dto.delivery;

import java.util.Set;

import entities.DishToDelivery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DeliveryDtoFull extends DeliveryDtoBase 
{
    private Integer id;
    private String notes;
    private Set <DishToDelivery> dishesDeliveries;

    private double dishesPrice;
    private double riderRevenue;
    private double totalPrice;

}
