package com.generation.flateat.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.flateat.model.entities.Menu;

public interface MenuRepository  extends JpaRepository<Menu,Integer>
{

}
