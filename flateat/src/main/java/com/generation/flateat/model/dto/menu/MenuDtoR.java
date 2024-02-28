package com.generation.flateat.model.dto.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class MenuDtoR extends MenuDtoBase
{
    public MenuDtoR(){};
    private Integer id;
}
