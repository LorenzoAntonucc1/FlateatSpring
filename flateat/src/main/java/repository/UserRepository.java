package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.User;

public interface UserRepository extends JpaRepository<User, Integer> 
{
    List<User> findByEmailContaining(String partialEmail);
    List<User> findByPhoneContaining(String phone);
}
