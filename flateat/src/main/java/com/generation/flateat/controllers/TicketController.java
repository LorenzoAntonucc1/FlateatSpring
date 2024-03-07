package com.generation.flateat.controllers;

import java.util.List;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.flateat.model.dto.ticket.TicketDtoBase;
import com.generation.flateat.model.dto.ticket.TicketDtoRPost;
import com.generation.flateat.model.dtoservices.TicketConverter;
import com.generation.flateat.model.entities.Reply;
import com.generation.flateat.model.entities.Ticket;
import com.generation.flateat.model.entities.User;
import com.generation.flateat.model.repositories.TicketRepository;
import com.generation.flateat.model.repositories.UserRepository;

@RestController
public class TicketController 
{

    @Autowired
    TicketRepository repo;

    @Autowired
    TicketConverter conv;

    @Autowired
    UserRepository uRepo;

    @GetMapping("/tickets")
    public List<TicketDtoBase> getAllTickets()
    {
        return repo.findAll()
                .stream()
                .map(e -> conv.toDtoBase(e))
                .toList();
    }

    @GetMapping("/tickets/{userId}")
    public List<TicketDtoRPost> getUserTickets(@PathVariable Integer userId)
    {
        User u = uRepo.findById(userId).get();
        List<TicketDtoRPost> setTicket = u.getTickets().stream().map(e -> conv.ticketToDtoR(e)).toList();
        return setTicket;
    }

    @GetMapping("/tickets/my/{id}")
    public List<Reply> getMyReply(@PathVariable Integer id)
    {
        return repo.findById(id).get().getReplies().stream().toList();
    }

    @PostMapping("/tickets/{id}")
    public Ticket readTicket(@RequestBody TicketDtoRPost dto, @PathVariable Integer id)
    {
        return repo.save(conv.DtoRToTicket(dto, id));
    }

    @DeleteMapping("/tickets/{id}")
    public void removeTicket(@PathVariable Integer id)
    {
        repo.deleteById(id);
    }
}
