package dto.dishtodelivery;
import entities.Delivery;
import entities.Dish;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public abstract class DishToDeliveryDtoBase 
{
    private  int quantity;
    private Dish dish;
    private Delivery delivery;

}
