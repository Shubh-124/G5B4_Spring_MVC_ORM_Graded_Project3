package com.glearning.tickettracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glearning.tickettracker.model.Ticket;

public interface TicketRepository extends JpaRepository <Ticket, Long> {

}
