package com.example.demo.controller;

import com.example.demo.entity.HelloEntity;
import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/")
    public String home() {
        return helloService.getHelloMessage();
    }

    @PostMapping("/add")
    public HelloEntity addEmployee(@RequestBody Map<String, Object> request) {
        String name = (String) request.get("name");
        double salary = Double.parseDouble(request.get("salary").toString());
        return helloService.saveHelloEntity(name, salary);
    }
}
