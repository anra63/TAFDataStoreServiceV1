package com.example.TafDatastoreService.Controller;

import com.example.TafDatastoreService.Models.User;
import com.example.TafDatastoreService.Models.Flight;
import com.example.TafDatastoreService.Models.Booking;
import com.example.TafDatastoreService.Service.TafDatastoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/datastore")
public class TafDatastoreServiceController {

    @Autowired
    private TafDatastoreService tafDatastoreService;  // Inject the service layer

    // User Endpoints

    @GetMapping("/test")
    public String test() {
        return "success";
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return tafDatastoreService.createUser(user);  // Call the service method
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return tafDatastoreService.getAllUsers();  // Call the service method
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        return tafDatastoreService.getUserById(id).orElse(null);  // Call the service method
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return tafDatastoreService.updateUser(id, user);  // Call the service method
    }

    // Flight Endpoints

    @PostMapping("/flights")
    public Flight createFlight(@RequestBody Flight flight) {
        return tafDatastoreService.createFlight(flight);  // Call the service method
    }

    @GetMapping("/flights/{id}")
    public Flight getFlight(@PathVariable Long id) {
        return tafDatastoreService.getFlightById(id).orElse(null);  // Call the service method
    }

    @GetMapping("/flights")
    public List<Flight> getAllFlights() {
        return tafDatastoreService.getAllFlights();  // Call the service method
    }

    @PutMapping("/flights/{id}")
    public Flight updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
        return tafDatastoreService.updateFlight(id, flight);  // Call the service method
    }

    // Booking Endpoints

    @PostMapping("/bookings")
    public Booking createBooking(@RequestBody Booking booking) {
        return tafDatastoreService.createBooking(booking);  // Call the service method
    }

    @GetMapping("/bookings/{id}")
    public Booking getBooking(@PathVariable Long id) {
        return tafDatastoreService.getBookingById(id).orElse(null);  // Call the service method
    }

    @GetMapping("/bookings/user/{userId}")
    public List<Booking> getBookingsByUser(@PathVariable Long userId) {
        return tafDatastoreService.getBookingsByUserId(userId);  // Call the service method
    }

    @DeleteMapping("/bookings/{id}")
    public void cancelBooking(@PathVariable Long id) {
        tafDatastoreService.cancelBooking(id);  // Call the service method
    }

    @GetMapping("/bookings")
    public List<Booking> getAllBookings() {
        return tafDatastoreService.getAllBookings();
    }

    @GetMapping("/deleteAllBookings")
    public void deleteAllBookings() {
        tafDatastoreService.deleteAllBookings();
    }
}
