package com.glearning.tickettracker.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.glearning.tickettracker.model.Ticket;
import com.glearning.tickettracker.service.TicketService;

@Controller
public class TicketController {

	private final TicketService ticketService;

	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	// search part
	@GetMapping("/tickets/search")
	public String searchTickets(@RequestParam("keyword") String keyword, Model model) {
		List<Ticket> tickets = ticketService.searchTicketsByKeyword(keyword);
		model.addAttribute("tickets", tickets);
		return "home";
	}

	// ticket main part

	@GetMapping("/tickets/new")
	public String showCreateTicketForm(Model model) {
		model.addAttribute("ticket", new Ticket());
		return "create";
	}

	@PostMapping("/tickets")
	public String createTicket(@ModelAttribute("ticket") Ticket ticket) {
		ticketService.createTicket(ticket);
		return "redirect:/";
	}

	@GetMapping("/tickets/{id}/edit")
	public String showEditTicketForm(@PathVariable("id") Long id, Model model) {
		Ticket ticket = ticketService.getTicketById(id);
		model.addAttribute("ticket", ticket);
		return "edit";
	}

	@PostMapping("/tickets/{id}")
	public String updateTicket(@PathVariable("id") Long id, @ModelAttribute("ticket") Ticket ticket) {
		ticket.setId(id);
		ticketService.updateTicket(ticket);
		return "redirect:/";
	}

	@GetMapping("/tickets/{id}")
	public String viewTicket(@PathVariable("id") Long id, Model model) {
		Ticket ticket = ticketService.getTicketById(id);
		model.addAttribute("ticket", ticket);
		return "view";
	}

	@GetMapping("/tickets/{id}/delete")
	public String deleteTicket(@PathVariable("id") Long id) {
		ticketService.deleteTicket(id);
		return "redirect:/";
	}
}
