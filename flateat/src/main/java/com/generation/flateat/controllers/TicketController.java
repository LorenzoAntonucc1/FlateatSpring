package com.generation.flateat.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.flateat.model.dto.ticket.TicketDtoRPost;
import com.generation.flateat.model.dtoservices.TicketConverter;
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
    public List<TicketDtoRPost> getAllTickets()
    {
        return repo.findAll()
                .stream()
                .map(e -> conv.ticketToDtoR(e))
                .toList();
    }

    @GetMapping("/tickets/{userId}")
    public List<TicketDtoRPost> getUserTickets(@PathVariable Integer userId)
    {
        User u = uRepo.findById(userId).get();
        List<TicketDtoRPost> setTicket = u.getTickets().stream().map(e -> conv.ticketToDtoR(e)).toList();
        return setTicket;
    }

    @PostMapping("/tickets")
    public Ticket readTicket(@RequestBody TicketDtoRPost dto)
    {
        return repo.save(conv.DtoRToTicket(dto));
    }

    @DeleteMapping("/tickets/{id}")
    public void removeTicket(@PathVariable Integer id)
    {
        repo.deleteById(id);
    }
}
