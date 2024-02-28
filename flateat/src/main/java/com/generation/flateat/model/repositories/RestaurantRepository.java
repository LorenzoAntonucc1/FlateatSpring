package com.generation.flateat.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.generation.flateat.model.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer>
{
    @Query(value = "call reset();", nativeQuery = true)
    void reset();
}
