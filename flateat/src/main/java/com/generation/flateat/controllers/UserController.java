
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

import com.generation.flateat.model.dto.user.UserDtoR;
import com.generation.flateat.model.dto.user.UserDtoRregister;
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


    // @GetMapping("/search")
    // public List<UserDtoW> searchUsersByEmailAndPhone(@RequestParam String partialEmail, @RequestParam String phone) {
    //     List<User> usersByEmail = repo.findByEmailContaining(partialEmail);
    //     List<User> usersByPhone = repo.findByPhoneContaining(phone);
        

    //     List<User> intersection = usersByEmail.stream()
    //             .filter(usersByPhone::contains)
    //             .collect(Collectors.toList());

    //     return intersection.stream()
    //             .map(conv::convertToDtoW)
    //             .collect(Collectors.toList());
    // }

    // @GetMapping("/{id}/login")
    // public UserDtoW getUserById(@RequestBody String email, @RequestBody String password) 
    // {
    //     User u = repo.findById(id).get();
    //     if(u.getEmail().equals(email) && u.getPassword().equals(password))
    //     return conv.convertToDtoW(repo.findById(id).orElse(null));
    //     else
    //     return null;
    // }

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
    public UserDtoWNoDeliveries addUser(@RequestBody UserDtoRregister u) 
    {
        User user = conv.DtoRregisterToUser(u);
        return conv.userToDtoWNoDeliveries(repo.save(user));
    }

    @PutMapping("/{id}")
    public UserDtoWFull updateUser(@PathVariable Integer id, @RequestBody UserDtoR userDto) 
    {
        User u = conv.DtoRToUser(userDto);

        u.setId(id);

        return conv.userToDtoWFull(repo.save(u));
        // User existingUser = repo.findById(id).orElse(null);
        // if (existingUser != null) 
        // {
        //     User updatedUser = conv.convertToEntity(userDto);
        //     updatedUser.setId(id);
        //     return conv.convertToDtoW(repo.save(updatedUser));
        // }
        // return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id)
    {
        repo.deleteById(id);
    }
}

