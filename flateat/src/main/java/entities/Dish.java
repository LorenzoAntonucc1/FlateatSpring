package entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dish 
{
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
}
