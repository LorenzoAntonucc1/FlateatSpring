package com.generation.flateat.model.dto.restaurant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class RestaurantDtoR extends RestaurantDtoBase
{
   public RestaurantDtoR(){};
   private Integer id;
   private int positionX;
   private int positionY;
   private String phone;
   private int openingH;
   private int closingH;
}
