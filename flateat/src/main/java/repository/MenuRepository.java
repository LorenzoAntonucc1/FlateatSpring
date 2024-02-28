package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Menu;

public interface MenuRepository extends JpaRepository<Menu,Integer>
{

}