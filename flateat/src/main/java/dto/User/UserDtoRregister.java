package dto.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class UserDtoRregister extends UserDtoBase
{
    public UserDtoRregister(){};
    private Integer id;
    private String phone;
    private int positionX;
    private int positionY;
}
