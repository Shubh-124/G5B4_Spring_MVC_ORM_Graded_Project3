package com.glearning.tickettracker.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.glearning.tickettracker.model.Ticket;
import com.glearning.tickettracker.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	private final TicketRepository ticketRepository;

	public TicketServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	@Override
	public List<Ticket> getAllTickets() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket getTicketById(Long id) {
		return ticketRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid ticket id: " + id));
	}

	@Override
	public void createTicket(Ticket ticket) {
		ticketRepository.save(ticket);
	}

	@Override
	public void updateTicket(Ticket ticket) {
		ticketRepository.save(ticket);
	}

	@Override
	public void deleteTicket(Long id) {
		ticketRepository.deleteById(id);
	}

	@Override
	public List<Ticket> searchTicketsByKeyword(String keyword) {
		List<Ticket> allTickets = ticketRepository.findAll();

		return allTickets.stream()
				.filter(ticket -> ticket.getTitle().toLowerCase().contains(keyword.toLowerCase())
						|| ticket.getDescription().toLowerCase().contains(keyword.toLowerCase()))
				.collect(Collectors.toList());
	}
}
