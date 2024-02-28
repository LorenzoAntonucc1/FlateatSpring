package entities;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Delivery 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime expectedArrivalTime;
    private int distance;
    private String paymentMethod; 
    private String notes;

    @JsonIgnore
    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @JsonIgnore
    @JoinColumn(name = "restaurant_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Restaurant restaurant;  

    @JsonIgnore
    @JoinColumn(name = "dishDeliveries_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Set <DishToDelivery> dishesDeliveries;

}
