package ru.viktorshiyan.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class HomeController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                           Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @PostMapping("message")
    public @ResponseBody String message() {
        return "success";
    }

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
