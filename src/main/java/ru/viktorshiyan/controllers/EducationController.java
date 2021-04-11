package ru.viktorshiyan.controllers;

import lombok.SneakyThrows;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.viktorshiyan.domain.Education;
import ru.viktorshiyan.repos.EducationRepository;

@RestController
public class EducationController {

    private EducationRepository educationRepository;

    public EducationController(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    @PostMapping("/education")
    public void education(@RequestBody Education education) {
        educationRepository.save(education);
    }

    @GetMapping("/education")
    public Iterable<Education> getAll() {
        return educationRepository.findAll();
    }

    @DeleteMapping("/education/{id}")
    public void delete(@PathVariable @Validated Long id) {
        educationRepository.deleteById(id);
    }

    @PutMapping("/education/{id}")
    @SneakyThrows
    public Education edit(@PathVariable Long id, @RequestBody Education education) {
        return educationRepository.findById(id)
                .map(result -> {
                    result.setName(education.getName());
                    result.setDescription(education.getDescription());
                    result.setPlace(education.getPlace());
                    result.setYearStart(education.getYearStart());
                    result.setYearFinish(education.getYearFinish());
                    return educationRepository.save(result);
                }).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
