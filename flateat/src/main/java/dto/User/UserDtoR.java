package dto.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
public class UserDtoR extends UserDtoBase
{
    public UserDtoR(){};
    private Integer id;
}
