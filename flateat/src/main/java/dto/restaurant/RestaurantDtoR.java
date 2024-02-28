package dto.restaurant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@SuperBuilder
public class RestaurantDtoR extends RestaurantDtoBase
{
   public RestaurantDtoR(){};
   private Integer id;
}
