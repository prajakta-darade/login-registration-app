package com.example.demo.Entity;


import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String password;
    private LocalDateTime currentdateandtime;
    
	public LocalDateTime getCurrentdateandtime() {
		return currentdateandtime;
	}
	public void setCurrentdateandtime(LocalDateTime currentdateandtime) {
		this.currentdateandtime = currentdateandtime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

  
}
