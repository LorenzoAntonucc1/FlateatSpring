
package com.generation.flateat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.flateat.model.dto.user.UserDtoRPost;
import com.generation.flateat.model.dto.user.UserDtoWFull;
import com.generation.flateat.model.dto.user.UserDtoWNoDeliveries;
import com.generation.flateat.model.dtoservices.UserConverter;
import com.generation.flateat.model.entities.User;
import com.generation.flateat.model.repositories.UserRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/users")
public class UserController 
{

    @Autowired
    UserRepository repo;

    @Autowired
    UserConverter conv;

    @GetMapping
    @Operation(description = "Returns a list of all Users")
    public List<UserDtoWNoDeliveries> getAllUsers() 
    {
        return  repo.findAll()
                .stream()
                .map(e -> conv.userToDtoWNoDeliveries(e))
                .toList();
    }

    @GetMapping("/login")
    @Operation(description = "Sends a specific User after both Front and Back End checks for its credentials")
    @ApiResponses(value = {
        @ApiResponse
        (
            description = "User Found and loggin accept",
            responseCode = "200",
            useReturnTypeSchema = true,
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
        ),
        @ApiResponse
        (
            description = "User not Found",
            responseCode = "404",
            content = @Content(mediaType = "text")
        )
    })
    public ResponseEntity<?> getLogged(@RequestBody String email, @RequestBody String password) 
    {
        List<User> allUsers = repo.findAll();
        for(User u : allUsers)
            if(u.getMail().equals(email) && u.getPassword().equals(password))
            {
                return new ResponseEntity<UserDtoWFull>(conv.userToDtoWFull(repo.findById(u.getId()).orElse(null)),HttpStatus.OK);
            }
        return new ResponseEntity<String>("User with "+email+" email and password not found",HttpStatus.NOT_FOUND);
    }

    @PostMapping("/register")
    @Operation(description = "Adds a new User | Front-End checks before accepting this request")
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

    @DeleteMapping("/{id}")
    @Operation(description = "Delete specific User by its ID")
    public void deleteUser(@PathVariable Integer id)
    {
        repo.deleteById(id);
    }
}

