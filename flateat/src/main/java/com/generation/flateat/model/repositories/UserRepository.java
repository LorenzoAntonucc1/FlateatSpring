package com.generation.flateat.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.flateat.model.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> 
{
    
}
