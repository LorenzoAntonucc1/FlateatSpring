package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery,Integer>
{

}