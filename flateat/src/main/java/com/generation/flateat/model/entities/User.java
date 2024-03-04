package com.generation.flateat.model.entities;

import java.util.Set;


import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String mail;
    private String password;
    private String phone;
    private int positionX;
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
