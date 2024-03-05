package com.generation.flateat.model.entities;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Object Delivery | 1 - N DishToDelivery | N - 1 User/Restaurant")
public class Delivery 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Primary Key | > 0")
    private Integer id;
    @Schema(description = "Calculates arrival time by: (2*distance) + delivery_time(chosen by user in fron-end)")
    private LocalDateTime expected_arrival;
    @Schema(description = "Distance bewtween User-Restaurant")
    private int distance;
    @Schema(description = "Card|Cash|Ecc.")
    private String paymentMethod; 
    @Schema(description = "Specific user request - Allergies|No Pickles|Ecc.")
    private String notes;

    @JsonIgnore
    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @Schema(description = "Foreign Key | user_id")
    private User user;

    @JsonIgnore
    @JoinColumn(name = "restaurant_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @Schema(description = "Foreign Key | restaurant_id")
    private Restaurant restaurant;  

    @JsonIgnore
    @OneToMany(mappedBy = "delivery",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private Set <DishToDelivery> dishesDeliveries;
}
