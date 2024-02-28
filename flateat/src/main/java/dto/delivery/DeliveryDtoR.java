package dto.delivery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
public class DeliveryDtoR extends DeliveryDtoBase
{
    public  DeliveryDtoR(){};
    private Integer id;
}
