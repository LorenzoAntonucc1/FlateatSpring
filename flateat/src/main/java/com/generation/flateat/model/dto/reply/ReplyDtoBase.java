package com.generation.flateat.model.dto.reply;

import com.generation.flateat.model.entities.Ticket;

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
public class ReplyDtoBase 
{
    private Integer id;
    private String text;
    private Ticket ticket;
}
