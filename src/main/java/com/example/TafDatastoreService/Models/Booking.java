package com.example.TafDatastoreService.Models;



//import javax.persistence.*;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "bookings")  // This specifies the table name in the database
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")  // Foreign key reference to 'user_accounts' table
    private User user;

    @ManyToOne
    @JoinColumn(name = "flight_id")  // Foreign key reference to 'flights' table
    private Flight flight;

    private String status;

    private String createdAt;
    private String updatedAt;

    // Getters and Setters
}

