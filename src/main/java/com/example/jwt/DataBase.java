package com.example.jwt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DataBase implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DataBase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

        this.userRepository.deleteAll();

        User alex = new User("alex",passwordEncoder.encode("alex0000"),"USER","");
        User dinu = new User("dinu",passwordEncoder.encode("dinu0000"),"USER","");
        User admin = new User("admin",passwordEncoder.encode("admin0000"),"ADMIN","");

        List<User> users = Arrays.asList(alex,dinu,admin);


        this.userRepository.saveAll(users);
    }
}
