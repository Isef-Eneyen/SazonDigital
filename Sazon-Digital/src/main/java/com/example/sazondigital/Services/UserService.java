package com.example.sazondigital.Services;

import com.example.sazondigital.Models.User;
import com.example.sazondigital.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public List<User> findAll() {return userRepository.findAll();}

    public User findById(int id) {return userRepository.findById(id).orElse(null);}

    public User findById(String email) {return userRepository.findByEmail(email);}

    public void Delete(User user) {userRepository.delete(user);}
}
