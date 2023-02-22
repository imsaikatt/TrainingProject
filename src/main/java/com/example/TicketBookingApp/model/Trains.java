package com.example.TicketBookingApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Trains {

    @Id
    private int train_no;
    private String train_name;
    private String train_time;
    private int ticket_price;
    private String stations;






}
