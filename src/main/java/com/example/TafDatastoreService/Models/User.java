package com.example.TafDatastoreService.Models;



import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//import lombok.AllArgsConstructor;

//import lombok.NoArgsConstructor;

//import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "TafUser")
public class User {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String email;
    private String phone;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters and Setters
}

