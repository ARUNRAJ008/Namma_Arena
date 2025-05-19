package com.project.test.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.test.DTO.UserLoginDTO;
import com.project.test.Repository.UserLoginRepository;

@RestController
@RequestMapping("/api")
public class LoginController
{
	@Autowired
	private UserLoginRepository userLoginRepository;
	
	// Test GET API
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Turf Booking App!";
    }
    
    @GetMapping("/users")
    public List<UserLoginDTO> getAllUsers() {
        return userLoginRepository.getAllUsers();
    }
    
    @PutMapping("/adduser")
    public String updateUser(@RequestBody UserLoginDTO user) {
        int rows = userLoginRepository.updateUser(user);
        if (rows > 0) {
            return "User updated successfully";
        } else {
            return "User not found or update failed";
        }
    }
}
