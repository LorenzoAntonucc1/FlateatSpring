package com.generation.flateat.model.dtoservices;

import org.springframework.stereotype.Service;

import com.generation.flateat.model.dto.user.UserDtoR;
import com.generation.flateat.model.dto.user.UserDtoRPost;
import com.generation.flateat.model.dto.user.UserDtoWFull;
import com.generation.flateat.model.dto.user.UserDtoWNoDeliveries;
import com.generation.flateat.model.entities.User;

@Service
public class UserConverter 
{

    public User DtoRToUser (UserDtoR dto)
    {
        return  User
                .builder()
                .mail(dto.getMail())
                .password(dto.getPassword())
                .id(dto.getId())
                .build();
    }
    
    public User DtoRregisterToUser (UserDtoRPost dto)
    {
        return  User
                .builder()
                .mail(dto.getMail())
                .password(dto.getPassword())
                .phone(dto.getPhone())
                .positionX(dto.getPositionX())
                .positionY(dto.getPositionY())
                .id(dto.getId())
                .build();
    }

    public UserDtoWNoDeliveries userToDtoWNoDeliveries (User user) 
    {
        return  UserDtoWNoDeliveries
                .builder()
                .id(user.getId())
                .mail(user.getMail())
                .password(user.getPassword())
                .phone(user.getPhone())
                .positionX(user.getPositionX())
                .positionY(user.getPositionY())
                .build();
    }

    public UserDtoWFull userToDtoWFull (User user) 
    {
        return  UserDtoWFull
                .builder()
                .id(user.getId())
                .mail(user.getMail())
                .password(user.getPassword())
                .phone(user.getPhone())
                .positionX(user.getPositionX())
                .positionY(user.getPositionY())
                .deliveries(user.getDeliveries())
                .build();
    }
}

