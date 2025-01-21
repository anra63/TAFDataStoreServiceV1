package com.example.TafDatastoreService.Models;



//import javax.persistence.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import lombok.AllArgsConstructor;

//import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "flights")  // This specifies the table name in the database
public class Flight {

    @Setter
    @Getter
    @Id
    //@AllArgsConstructor
    //@NoArgsConstructor
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String flightNumber;

    private String departure;
    private String arrival;

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    private double price;
    private int availableSeats;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;




    // Getters and Setters
}

