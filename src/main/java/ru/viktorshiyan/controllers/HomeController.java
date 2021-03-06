package ru.viktorshiyan.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.viktorshiyan.data.DataForHome;
import ru.viktorshiyan.domain.Education;
import ru.viktorshiyan.domain.Experience;
import ru.viktorshiyan.repos.EducationRepository;
import ru.viktorshiyan.repos.ExperinceRepository;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class HomeController {
    @Value("${email.send}")
    private String fromMail;

    private final DataForHome dataForHome;
    private final JavaMailSender emailSender;
    private final EducationRepository educationRepository;
    private final ExperinceRepository experinceRepository;

    @PostMapping(value = "message")
    public @ResponseBody
    String message(@RequestParam String name, @RequestParam String email, @RequestParam String message) {
        System.out.println("Success");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromMail);
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
    @GetMapping("/")
    public String main(Map<String, Object> model) {
        model.put("some", "MAIN");
        model.putAll(dataForHome.getDataMap());
        List<Education> educationList = new ArrayList<>();
        educationRepository.findAll().forEach(educationList::add);
        List<Experience> experienceList = new ArrayList<>();
        experinceRepository.findAll().forEach(experienceList::add);
        educationList.sort(Comparator.comparing(Education::getYearStart));
        experienceList.sort(Comparator.comparing(Experience::getID));
        model.put("educations", educationList);
        model.put("experience", experienceList);
        return "index";
    }


}
