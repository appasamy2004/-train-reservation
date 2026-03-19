package com.train.reservation.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Booking {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String passengerName;
        private int seatsBooked;

        @ManyToOne
        private Train train;
        @ManyToOne
        private User user;
}