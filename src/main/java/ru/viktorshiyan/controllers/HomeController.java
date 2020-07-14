package ru.viktorshiyan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class HomeController {

    @Autowired
    private ApplicationContext applicationContext;

    //TODO implement sending email
    @PostMapping("message")
    public @ResponseBody
    String message() {
        return "success";
    }

    /**
     * Home page
     *
     * @param model
     * @return view
     */
    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("some", "MAIN");
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        calendar.setTime(new Date());
        int currentYear = calendar.get(Calendar.YEAR);
        model.put("age", currentYear - 1991);
        return "index";
    }


}
