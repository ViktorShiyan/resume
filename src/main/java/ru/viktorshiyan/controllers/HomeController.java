package ru.viktorshiyan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.viktorshiyan.data.DataForHome;
import ru.viktorshiyan.data.Sender;

import java.util.*;

@Controller
public class HomeController {

    @Autowired
    DataForHome dataForHome;
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    private ApplicationContext applicationContext;

    @PostMapping(value = "message")
    public @ResponseBody
    String message(@RequestParam String name, @RequestParam String email, @RequestParam String message) {
        System.out.println("Success");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("resume@viktorshiyan.ru");
        simpleMailMessage.setTo("me@viktorshiyan.ru");
        simpleMailMessage.setSubject("RESUME OF " + name);
        simpleMailMessage.setText(message + "\n" + email + "\n" + name);
        emailSender.send(simpleMailMessage);
        return "success";
    }

    /**
     * Home page
     *
     * @param model map data for home
     * @return view
     */
    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("some", "MAIN");
        model.putAll(dataForHome.getDataMap());
        return "index";
    }


}
