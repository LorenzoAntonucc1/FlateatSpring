package dto.restaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class RestaurantDtoBase 
{
    private String phone;
    private int openingH;
    private int closingH;
    private String imgUrl;
}
