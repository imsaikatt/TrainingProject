package com.example.TicketBookingApp.repository;

import com.example.TicketBookingApp.model.Trains;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainsRepository extends JpaRepository<Trains,Integer> {
}
