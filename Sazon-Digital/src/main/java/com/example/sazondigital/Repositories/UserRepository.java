package com.example.sazondigital.Repositories;

import com.example.sazondigital.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByUsername(String email);
}
