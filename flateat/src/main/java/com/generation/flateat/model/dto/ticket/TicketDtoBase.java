package com.generation.flateat.model.dto.ticket;

import com.generation.flateat.model.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class TicketDtoBase 
{
    private Integer id;
    private String text;
    private User userOfTicket;
}
