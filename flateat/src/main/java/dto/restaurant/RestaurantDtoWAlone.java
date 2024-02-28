package dto.restaurant;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class RestaurantDtoWAlone extends RestaurantDtoBase
{
    private Integer id;
    private boolean isOpen;
    private List<String> foodTypes;
    private int distance;
}
