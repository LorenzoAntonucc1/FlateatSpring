package entities;

import java.util.List;

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
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;
    private String phone;
    private int positionX;
    private int positionY;
    private Set<Delivery> deliveries;

    @JsonIgnore
    @OneToMany(mappedBy = "",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private Set<Delivery> questions;
}
