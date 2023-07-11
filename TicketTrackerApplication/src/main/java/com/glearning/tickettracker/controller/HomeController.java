package com.glearning.tickettracker.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.glearning.tickettracker.model.Ticket;
import com.glearning.tickettracker.service.TicketService;

@Controller
public class HomeController {

    private final TicketService ticketService;

    public HomeController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Ticket> tickets = ticketService.getAllTickets();
        model.addAttribute("tickets", tickets);
        return "home";
    }
}	
