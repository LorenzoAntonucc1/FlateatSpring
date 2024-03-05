package com.generation.flateat.model.entities;

import java.util.Set;


import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Schema(description = "Object User | N - 1 DishToDelivery")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Primary Key | > 0")
    private Integer id;
    @Schema(description = "Used for Logging In | One SpecialUser has specific powers")
    private String mail;
    @Schema(description = "Used for Loggin In | One SpecialUser has specific powers")
    private String password;
    private String phone;
    @Schema(description = "User X position in the city (0-1000)")
    private int positionX;
    @Schema(description = "User Y position in the city (0-1000)")
    private int positionY;

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)//cascade sempre sul padre
    private Set<Delivery> deliveries;

    @JsonIgnore
    @OneToMany(mappedBy = "userOfReview",fetch = FetchType.EAGER)
    private Set<Review> reviews;

    @JsonIgnore
    @OneToMany(mappedBy = "userOfTicket",fetch = FetchType.EAGER)
    private Set<Ticket> tickets;
}
