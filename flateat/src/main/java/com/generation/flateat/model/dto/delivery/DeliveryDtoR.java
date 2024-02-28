package com.generation.flateat.model.dto.delivery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class DeliveryDtoR extends DeliveryDtoBase
{
    public  DeliveryDtoR(){};
    private Integer id;
}
