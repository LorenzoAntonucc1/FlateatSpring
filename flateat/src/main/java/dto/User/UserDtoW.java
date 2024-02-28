package dto.User;
import java.util.Set;

import entities.Delivery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class UserDtoW extends UserDtoBase{


    private String email;
    private String password;
public class UserDtoW extends UserDtoBase
{
    private Integer id;
    private String phone;
    private Set<Delivery> deliveries;
}
