package com.generation.flateat.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.flateat.model.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>
{

}
