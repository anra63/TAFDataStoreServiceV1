package com.example.TafDatastoreService.Service;



import com.example.TafDatastoreService.Models.User;
import com.example.TafDatastoreService.Models.Flight;
import com.example.TafDatastoreService.Models.Booking;
import com.example.TafDatastoreService.Repositories.UserRepository;
import com.example.TafDatastoreService.Repositories.FlightRepository;
import com.example.TafDatastoreService.Repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TafDatastoreServiceImpl implements TafDatastoreService {

    private final UserRepository userRepository;
    private final FlightRepository flightRepository;
    private final BookingRepository bookingRepository;

    @Autowired
    public TafDatastoreServiceImpl(UserRepository userRepository, FlightRepository flightRepository, BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.flightRepository = flightRepository;
        this.bookingRepository = bookingRepository;
    }

    // User-related methods
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();}

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);  // Ensure the ID is set for the update operation
            return userRepository.save(user);
        }
        return null;
    }

    // Flight-related methods
    @Override
    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Optional<Flight> getFlightById(Long id) {
        return flightRepository.findById(id);
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Flight updateFlight(Long id, Flight flight) {
        if (flightRepository.existsById(id)) {
            flight.setId(id);  // Ensure the ID is set for the update operation
            return flightRepository.save(flight);
        }
        return null;
    }

    // Booking-related methods
    @Override
    public Booking createBooking(Booking booking) {
        bookingRepository.saveAndFlush(booking);
        Optional<User> myUpdatedUser = getUserById(booking.getUser().getId());
        Optional<Flight> myUpdatedFlight = getFlightById(booking.getFlight().getId());
        booking.setUser(myUpdatedUser.orElse(null));
        booking.setFlight(myUpdatedFlight.orElse(null));
        return booking;
    }

    @Override
    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    @Override
    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    @Override
    public void cancelBooking(Long id) {
        Optional<Booking> bookingOptional = bookingRepository.findById(id);
        bookingOptional.ifPresent(booking -> {
            booking.setStatus("Cancelled");
            bookingRepository.save(booking);
        });
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();

    }

    @Override
    public void deleteAllBookings() {
        bookingRepository.deleteAll();
    }
}

