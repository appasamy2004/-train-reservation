package com.train.reservation.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trainName;
    private String source;
    private String destination;
    private int seatsAvailable;
}