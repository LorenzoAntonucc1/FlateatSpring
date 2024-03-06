package com.generation.flateat.model.dtoservices;

import org.springframework.stereotype.Service;

import com.generation.flateat.model.dto.ticket.TicketDtoBase;
import com.generation.flateat.model.dto.ticket.TicketDtoRPost;
import com.generation.flateat.model.entities.Ticket;

@Service
public class TicketConverter 
{

    public Ticket DtoRToTicket (TicketDtoRPost dto)
    {
        return Ticket
            .builder()
            .text(dto.getText())
            .id(dto.getId())
            .userOfTicket(dto.getUserOfTicket())
            .build();
    }

    public TicketDtoRPost ticketToDtoR(Ticket t)
    {
        return TicketDtoRPost.builder()
                .id(t.getId())
                .text(t.getText())
                .userOfTicket(t.getUserOfTicket())
                .replies(t.getReplies().stream().toList())
                .build();
    }

    public TicketDtoBase toDtoBase(Ticket t)
    {
        return TicketDtoBase.builder()
        .id(t.getId())
        .text(t.getText())
        .userOfTicket(t.getUserOfTicket())
        .build();
    }
}
