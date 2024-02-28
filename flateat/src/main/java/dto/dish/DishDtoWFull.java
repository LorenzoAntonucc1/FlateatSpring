package dto.dish;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DishDtoWFull extends DishDtoBase 
{
    private Integer id;
    private String category;
    private List <String> ingredients;
}
