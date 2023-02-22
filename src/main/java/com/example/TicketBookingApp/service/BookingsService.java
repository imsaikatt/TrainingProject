package com.example.TicketBookingApp.service;

import com.example.TicketBookingApp.model.Bookings;
import com.example.TicketBookingApp.model.Trains;
import com.example.TicketBookingApp.repository.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingsService {

    @Autowired
    BookingsRepository bookingsRepositoryObject;

    public void bookTicket(Bookings bookings){
        bookingsRepositoryObject.save(bookings);
    }

    public List<Bookings> displayTicket(){
       return bookingsRepositoryObject.findAll();
    }

    public Optional<Bookings> displayByTicket(int ticket_id){
        return bookingsRepositoryObject.findById(ticket_id);
    }


    public String cancelTicket(int ticket_id){
        bookingsRepositoryObject.deleteById(ticket_id);
        return "Ticket Cancel Successfuly";
    }
}
