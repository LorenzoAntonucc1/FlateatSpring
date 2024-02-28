
package com.generation.flateat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.flateat.model.dto.user.UserDtoRPost;
import com.generation.flateat.model.dto.user.UserDtoWFull;
import com.generation.flateat.model.dto.user.UserDtoWNoDeliveries;
import com.generation.flateat.model.dtoservices.UserConverter;
import com.generation.flateat.model.entities.User;
import com.generation.flateat.model.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController 
{

    @Autowired
    UserRepository repo;

    @Autowired
    UserConverter conv;

    @GetMapping
    public List<UserDtoWNoDeliveries> getAllUsers() 
    {
        return  repo.findAll()
                .stream()
                .map(e -> conv.userToDtoWNoDeliveries(e))
                .toList();
    }

    @GetMapping("/login")
    public UserDtoWFull getLogged(@RequestBody String email, @RequestBody String password) 
    {
        List<User> allUsers = repo.findAll();
        for(User u : allUsers)
            if(u.getMail().equals(email) && u.getPassword().equals(password))
                return conv.userToDtoWFull(repo.findById(u.getId()).orElse(null));

        return null;
    }

    @PostMapping("/register")
    public UserDtoWNoDeliveries addUser(@RequestBody UserDtoRPost u) 
    {
        User user = conv.DtoRregisterToUser(u);
        return conv.userToDtoWNoDeliveries(repo.save(user));
    }

    // @PutMapping("/{id}")
    // public UserDtoWFull updateUser(@PathVariable Integer id, @RequestBody UserDtoR userDto) 
    // {
    //     User u = conv.DtoRToUser(userDto);

    //     u.setId(id);

    //     return conv.userToDtoWFull(repo.save(u));
    // }

    // @DeleteMapping("/{id}")
    // public void deleteUser(@PathVariable Integer id)
    // {
    //     repo.deleteById(id);
    // }
}

