package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.cognizant.repository.UserRepository;
import com.cognizant.models.Users;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(Users user) { return userRepository.save(user); }
    public List<Users> getAllUsers() { return userRepository.findAll(); }
    public Users getUserById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found: " + id));
    }
    public void deleteUser(Long id) { userRepository.deleteById(id); }
}
