package com.generation.flateat.model.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class UserDtoRPost extends UserDtoBase
{
    public UserDtoRPost(){};
    private Integer id;
    private String phone;
    private int positionX;
    private int positionY;
}
