package com.glearning.tickettracker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.glearning.tickettracker.model.Ticket;
import com.glearning.tickettracker.repository.TicketRepository;

import java.time.LocalDate;

@Configuration
public class BootstrapAppData {

    @Autowired
    private TicketRepository ticketRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void onReady(ApplicationReadyEvent event) {

        Ticket java = new Ticket();
        java.setTitle("Default Ticket");
        java.setDescription("This ticket is not booked successfully");
        java.setCreatedOn(LocalDate.of(2020, 9, 9));

        this.ticketRepository.save(java);
    }
}
