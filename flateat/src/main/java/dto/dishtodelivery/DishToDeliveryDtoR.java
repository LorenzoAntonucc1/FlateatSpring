package dto.dishtodelivery;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder

public class DishToDeliveryDtoR extends DishToDeliveryDtoBase {
    private Integer id;

   
    public double getTotalPrice() {
        if (getDish() != null) {
            return getQuantity() * getDish().getPrice();
        } else {
            return 0.0; // Gestisce il caso 
        }
    }
}
