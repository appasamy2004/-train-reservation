package com.train.reservation.service;

import com.train.reservation.model.Booking;
import com.train.reservation.model.Train;
import com.train.reservation.model.User;
import com.train.reservation.repository.BookingRepository;
import com.train.reservation.repository.TrainRepository;
import com.train.reservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public List<Train> searchTrains(String source, String destination) {
        return trainRepository.findBySourceAndDestination(source, destination);
    }


    public String bookTicket(Long trainId, String name, int seats, String username) {

        Train train = trainRepository.findById(trainId).orElse(null);

        if (train == null) return "Train not found";

        if (seats <= 0) return "Invalid seat count";

        if (train.getSeatsAvailable() < seats) {
            return "Not enough seats available";
        }

        train.setSeatsAvailable(train.getSeatsAvailable() - seats);
        trainRepository.save(train);

        Booking booking = new Booking();
        booking.setPassengerName(name);
        booking.setSeatsBooked(seats);
        booking.setTrain(train);

        // 🔥 Set user
        User user = userRepository.findByUsername(username).orElse(null);
        booking.setUser(user);

        bookingRepository.save(booking);

        return "Booking successful!";
    }

    public List<Booking> getBookingHistory(String username) {
        return bookingRepository.findByUserUsername(username);
    }
}