package com.train.reservation.controller;

import com.train.reservation.model.Booking;
import com.train.reservation.model.Train;
import com.train.reservation.service.TrainService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

import java.security.Principal;
import java.util.List;

@Controller
public class TrainController {

    @Autowired
    private TrainService trainService;

    @GetMapping("/")
    public String home() {
        return "index"; // Spring Security already protects this
    }

    @PostMapping("/search")
    public String searchTrains(@RequestParam String source,
                               @RequestParam String destination,
                               Model model) {

        List<Train> trains = trainService.searchTrains(source, destination);
        model.addAttribute("trains", trains);

        return "results";
    }



    @PostMapping("/book")
    public String bookTicket(@RequestParam Long trainId,
                             @RequestParam String name,
                             @RequestParam int seats,
                             Principal principal,
                             Model model) {

        String username = principal.getName();

        String result = trainService.bookTicket(trainId, name, seats, username);
        model.addAttribute("message", result);

        return "booking-result";
    }
    @GetMapping("/history")
    public String bookingHistory(Model model, Principal principal) {

        String username = principal.getName();

        List<Booking> bookings = trainService.getBookingHistory(username);

        model.addAttribute("bookings", bookings);

        return "history";
    }
}