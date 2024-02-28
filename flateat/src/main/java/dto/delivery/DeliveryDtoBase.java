package dto.delivery;

import java.time.LocalDateTime;

import entities.Restaurant;
import entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class DeliveryDtoBase 
{

    private LocalDateTime expected_arrival;
    private int distance;
    private User user;
    private Restaurant restaurant;  
    private String paymentMethod; 

}
