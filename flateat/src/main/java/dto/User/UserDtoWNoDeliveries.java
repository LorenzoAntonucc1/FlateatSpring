package dto.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserDtoWNoDeliveries extends UserDtoBase
{
    private Integer id;
    private String phone;
    private int positionX;
    private int positionY;
}
