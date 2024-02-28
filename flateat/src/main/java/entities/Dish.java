package entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER) 
    //Nome tabella
    @CollectionTable(name = "ingredients", joinColumns = @JoinColumn(name = "dish_id")) 
    //Nome proprietà
    @Column(name = "ingredient", nullable = false)                     
    private List <String> ingredients = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "", fetch = FetchType.EAGER)
    private Set<DishToDelivery> deliveries;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id")
    private Menu menu;

}
