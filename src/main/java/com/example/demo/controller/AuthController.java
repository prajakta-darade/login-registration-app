package com.example.demo.controller;

import com.example.demo.Entity.User;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class AuthController {

    @Autowired
    private UserService userService;
    
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (user.getName() == null || user.getName().isEmpty()) {
            return ResponseEntity.badRequest().body("Name is required");
        }

        if (user.getEmail() == null || !user.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            return ResponseEntity.badRequest().body("Invalid email");
        }

        if (user.getPassword() == null || user.getPassword().length() < 6) {
            return ResponseEntity.badRequest().body("Password must be at least 6 characters");
        }

        if (!user.getPassword().matches(".*[a-z].*")) {
            return ResponseEntity.badRequest().body("Password must contain at least one lowercase letter");
        }

        if (userService.getByEmail(user.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Email already registered");
        }
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        userService.register(user);
        return ResponseEntity.ok("registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials, HttpSession session) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        User user = userService.login(email, password);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }

        session.setAttribute("user", user);
        return ResponseEntity.ok("Login successful");
    }

    @GetMapping("/dashboard")
    public ResponseEntity<?> dashboard(HttpSession session) {
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Please login");
        }

        Map<String, String> userData = new HashMap<>();
        userData.put("name", user.getName());
        userData.put("email", user.getEmail());

        return ResponseEntity.ok(userData);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("Logged out successfully");
    }
    
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(HttpSession session) {
        User currentUser = (User) session.getAttribute("user");

        if (currentUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Please login");
        }

        return ResponseEntity.ok(userService.getAllUsers());
    }

}
