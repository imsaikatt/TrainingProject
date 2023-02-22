package com.example.TicketBookingApp.service;

import com.example.TicketBookingApp.model.Trains;
import com.example.TicketBookingApp.repository.TrainsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainsService {

    @Autowired
    TrainsRepository trainsRepositoryObject;


    public void addTrains(Trains trains){
        trainsRepositoryObject.save(trains);
    }

    public List<Trains> displayTrains(){
        return trainsRepositoryObject.findAll();
    }

    public Optional<Trains> displayByTrainsno(int train_no){
        return trainsRepositoryObject.findById(train_no);
    }

    public String deleteById(int train_no){
        trainsRepositoryObject.deleteById(train_no);
        return "Record is deleted";
    }

    public String update(int train_no, Trains trains){
        if(trainsRepositoryObject.findById(train_no)!=null){
            trainsRepositoryObject.deleteById(train_no);
            trainsRepositoryObject.save(trains);
            return "Updated Successfully";
        }
        return "Train No is not exist in Database";
    }
}

