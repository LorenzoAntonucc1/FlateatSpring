package dto.restaurant;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class RestaurantDtoWsec extends RestaurantDtoBase
{
    private Integer id;
    private String name;
    private boolean isOpen;
    private List<String> foodTypes;
    private int distanza;

}
