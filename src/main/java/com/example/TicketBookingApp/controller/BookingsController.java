package com.example.TicketBookingApp.controller;

import com.example.TicketBookingApp.model.Bookings;
import com.example.TicketBookingApp.service.BookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingsController {

    @Autowired
    BookingsService bookingsServiceObject;

    @PostMapping("/bookticket")
    public String bookTicket(@RequestBody Bookings bookings){
        bookingsServiceObject.bookTicket(bookings);
        return "Ticket booking successful";
    }

    @GetMapping("/displaytickets")
    public List<Bookings> displayTicket(){
        return bookingsServiceObject.displayTicket();
    }

    @GetMapping("/displayticketbyid/{ticket_id}")
    public Optional<Bookings> displayByTrainsno(@PathVariable int ticket_id){
        return bookingsServiceObject.displayByTicket(ticket_id);

    }

    @DeleteMapping("cancelticket/{ticket_no}")
    public String cancelTicket(@PathVariable int ticket_no){
        return bookingsServiceObject.cancelTicket(ticket_no);
    }
}
