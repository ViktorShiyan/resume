package ru.viktorshiyan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.viktorshiyan.domain.Person;
import ru.viktorshiyan.repos.UserRepository;

import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public String addNewUser(@RequestParam String name
            , @RequestParam String email) {

        Person n = new Person();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }


    @GetMapping("user")
    public Iterable<Person> all(Map<String, Object> model) {
        return userRepository.findAll();
    }
}
