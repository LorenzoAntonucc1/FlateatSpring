package com.generation.flateat.model.dtoservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.flateat.model.dto.ticket.TicketDtoBase;
import com.generation.flateat.model.dto.ticket.TicketDtoRPost;
import com.generation.flateat.model.entities.Ticket;
import com.generation.flateat.model.repositories.UserRepository;

@Service
public class TicketConverter 
{
    @Autowired
    UserRepository uRepo;

    public Ticket DtoRToTicket (TicketDtoRPost dto, int i)
    {
        return Ticket
            .builder()
            .text(dto.getText())
            .id(dto.getId())
            .userOfTicket(uRepo.findById(i).get())
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
