package com.example.TicketBookingApp.controller;

import com.example.TicketBookingApp.model.Bookings;
import com.example.TicketBookingApp.model.Trains;
import com.example.TicketBookingApp.service.BookingsService;
import com.example.TicketBookingApp.service.TrainsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TrainsController {

    @Autowired
    TrainsService trainsServiceObject;


    @GetMapping("/")
    public String home(){
        return "HELLO ! WELCOME TO RAILWAY TICKET BOOKING SYSTEM";
    }


    @PostMapping("/addtrain")
    public String addTrains(@RequestBody Trains trains){
        trainsServiceObject.addTrains(trains);
        return "Train Added";
    }

    @GetMapping("/displaytrains")
    public List<Trains> displayAll(){
        return trainsServiceObject.displayTrains();
    }

    @GetMapping("/trainsbyno/{train_no}")
    public Optional<Trains> displayByTrainsno(@PathVariable int train_no){
        return trainsServiceObject.displayByTrainsno(train_no);

    }

    @PostMapping("/updatetrain/{train_no}")
    public String updateTrain(@PathVariable int train_no, @RequestBody Trains trains){
        return trainsServiceObject.update(train_no,trains);
    }


    @DeleteMapping("/deletetrain/{train_no}")
    public String deleteTrain(@PathVariable int train_no){
        return trainsServiceObject.deleteById(train_no);
    }




}
