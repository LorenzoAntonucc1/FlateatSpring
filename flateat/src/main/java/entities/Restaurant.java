package entities;
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
    private List <String> foodTypes;

    private double deliveryPricePerUnit;
    private int maxDeliveryDistance;
    private String imgUrl;

    @JsonIgnore 
    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private Set<Delivery> deliveries;

    @JsonIgnore
    @OneToOne(mappedBy = "restaurant",fetch = FetchType.EAGER)
    private Menu menu;
}
