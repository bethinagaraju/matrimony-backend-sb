package com.example.demo.service;

import com.example.demo.entity.HelloEntity;
import com.example.demo.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Autowired
    private HelloRepository helloRepository;

    public String getHelloMessage() {
        // For simplicity, return a hardcoded message or fetch from entity
        return "hello macha springboot";
    }

    // Method to save an entity with name and salary
    public HelloEntity saveHelloEntity(String name, double salary) {
        HelloEntity entity = new HelloEntity(name, salary);
        return helloRepository.save(entity);
    }
}
