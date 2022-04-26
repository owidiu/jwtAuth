package com.example.jwt;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/public")
@CrossOrigin
public class ApiController {
    private UserRepository userRepository;

    public ApiController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("test")
    public String test1(){
        return "API Test";
    }

    // Available to managers
    @GetMapping("management/reports")
    public String reports(){
        return "Data report";
    }

    @GetMapping("admin/users")
    public List<User> users(){
        return this.userRepository.findAll();
    }
}