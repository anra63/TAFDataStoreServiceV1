package com.example.TafDatastoreService.Service;



import com.example.TafDatastoreService.Models.User;
import com.example.TafDatastoreService.Models.Flight;
import com.example.TafDatastoreService.Models.Booking;

import java.util.List;
import java.util.Optional;

public interface TafDatastoreService {

    // User-related methods
    User createUser(User user);
     List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User updateUser(Long id, User user);

    // Flight-related methods
    Flight createFlight(Flight flight);
    Optional<Flight> getFlightById(Long id);
    List<Flight> getAllFlights();
    Flight updateFlight(Long id, Flight flight);

    // Booking-related methods
    Booking createBooking(Booking booking);
    Optional<Booking> getBookingById(Long id);
    List<Booking> getBookingsByUserId(Long userId);
    void cancelBooking(Long id);
    List<Booking> getAllBookings();
    void deleteAllBookings();
}

