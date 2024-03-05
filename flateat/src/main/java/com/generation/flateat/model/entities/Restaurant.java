package com.generation.flateat.model.entities;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Schema(description = "Object Restaurant | 1 - N Delivery/Menu")
public class Restaurant 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Primary Key | > 0")
    private Integer id;
    @Schema(description = "Funny names not created by AIs")
    private String name;
    private String phone;
    @Schema(description = "Opening hour of the Restaurant")
    private int openingHour;
    @Schema(description = "Closing hour of the Restaurant")
    private int closingHour;
    @Schema(description = "Restaurant X position in the city (0-1000)")
    private int positionX;
    @Schema(description = "Restaurant Y position in the city (0-1000)")
    private int positionY;

    //Tipo da leggere
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER) 
    //Nome tabella
    @CollectionTable(name = "foodTypes", joinColumns = @JoinColumn(name = "restaurant_id")) 
    //Nome proprietà
    @Column(name = "foodType", nullable = false)             
    private List <String> foodTypes;

    @Schema(description = "Delivery price calculated by distance*deliveryPricePerUnit")
    private double deliveryPricePerUnit;
    @Schema(description = "Even Restaurants in Flatlandia has limits")
    private int maxDeliveryDistance;
    @Schema(description = "Restaurant Image")
    private String imgUrl;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant",fetch = FetchType.EAGER)
    private Set<Delivery> deliveries;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurantOfReview",fetch = FetchType.EAGER)
    private Set<Review> reviews;
}
