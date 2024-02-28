package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Dish;

public interface DishRepository extends JpaRepository<Dish,Integer>
{

}