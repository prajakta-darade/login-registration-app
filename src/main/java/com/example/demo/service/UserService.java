package com.example.demo.service;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;
    
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User register(User user) {
    	user.setCurrentdateandtime(LocalDateTime.now());
        return repo.save(user);
    }

    public User login(String email, String rawPassword) {
        User user = repo.findByEmail(email);
        if (user != null && passwordEncoder.matches(rawPassword, user.getPassword())) {
            return user;
        }
        return null;
    }

    public User getByEmail(String email) {
        return repo.findByEmail(email);
    }

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
}
