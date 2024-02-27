package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer>
{
    List<Restaurant> findByNameContaining(String nome);

    List<Restaurant> findByFoodTypesContaining(String foodType);
}
