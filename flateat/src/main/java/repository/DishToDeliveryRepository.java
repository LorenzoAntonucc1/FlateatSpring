package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.DishToDelivery;

public interface DishToDeliveryRepository extends JpaRepository<DishToDelivery,Integer>
{

}