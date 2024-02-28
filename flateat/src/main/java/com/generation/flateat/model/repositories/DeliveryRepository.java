package com.generation.flateat.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.flateat.model.entities.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery,Integer>
{

}