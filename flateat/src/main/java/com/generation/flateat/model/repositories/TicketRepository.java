package com.generation.flateat.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.flateat.model.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>
{

}
