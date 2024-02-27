package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer>
{
    
}
