package com.generation.flateat.model.entities;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
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
public class Dish 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;    
    private String name;
    private String category;
    private double price;
    //Tipo da leggere
    @ElementCollection(targetClass = String.class, fetch = FetchType.LAZY) 
    //Nome tabella
    @CollectionTable(name = "ingredients", joinColumns = @JoinColumn(name = "dish_id")) 
    //Nome proprietà
    @Column(name = "ingredient", nullable = false)       
    private List <String> ingredients;

    @JsonIgnore
    @OneToMany(mappedBy = "dish",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private Set<DishToDelivery> deliveries;

    @JsonIgnore
    @JoinColumn(name = "menu_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Menu menu;

}
