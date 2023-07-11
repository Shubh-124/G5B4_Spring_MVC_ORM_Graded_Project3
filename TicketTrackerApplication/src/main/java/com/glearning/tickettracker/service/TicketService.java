package com.glearning.tickettracker.service;

import java.util.List;

import com.glearning.tickettracker.model.Ticket;

public interface TicketService {

	List<Ticket> getAllTickets();

	Ticket getTicketById(Long id);

	void createTicket(Ticket ticket);

	void updateTicket(Ticket ticket);

	void deleteTicket(Long id);

	List<Ticket> searchTicketsByKeyword(String keyword);
}
