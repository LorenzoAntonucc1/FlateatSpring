package dto.restaurant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
public class RestaurantDtoR extends RestaurantDtoBase
{
   public RestaurantDtoR(){};
   private Integer id;
}
