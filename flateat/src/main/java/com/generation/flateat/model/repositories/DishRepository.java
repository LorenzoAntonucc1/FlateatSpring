package com.generation.flateat.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.flateat.model.entities.Dish;

public interface DishRepository extends JpaRepository<Dish,Integer>
{

}
