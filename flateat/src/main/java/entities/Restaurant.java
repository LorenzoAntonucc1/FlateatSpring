package entities;
import java.util.ArrayList;
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
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Restaurant 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String phone;
    private int openingHour;
    private int closingHour;
    private int positionX;
    private int positionY;

    //Tipo da leggere
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER) 
    //Nome tabella
    @CollectionTable(name = "foodTypes", joinColumns = @JoinColumn(name = "restaurant_id")) 
    //Nome proprietà
    @Column(name = "type", nullable = false)                     
    private List <String> foodTypes = new ArrayList<>();



    private double deliveryPricePerUnit;
    private int maxDeliveryDistance;
    private String imgUrl;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id")
    private Set<Delivery> deliveries;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id")
    private Menu menu;
}
