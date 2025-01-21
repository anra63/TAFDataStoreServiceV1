package com.example.TafDatastoreService.Repositories;

import com.example.TafDatastoreService.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);


}
