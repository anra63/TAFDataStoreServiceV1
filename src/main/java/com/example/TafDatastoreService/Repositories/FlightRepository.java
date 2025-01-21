package com.example.TafDatastoreService.Repositories;



import com.example.TafDatastoreService.Models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    Flight findByFlightNumber(String flightNumber);
}

