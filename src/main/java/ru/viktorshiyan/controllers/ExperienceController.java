package ru.viktorshiyan.controllers;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;
import ru.viktorshiyan.domain.Experience;
import ru.viktorshiyan.repos.ExperinceRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class ExperienceController implements CrudController<Experience> {
    private final ExperinceRepository experinceRepository;


    @Override
    @PostMapping("/experience")
    public Experience create(@RequestBody Experience body) {
        return experinceRepository.save(body);
    }

    @Override
    @DeleteMapping("/experience/{id}")
    public String delete(@PathVariable Long id) {
        experinceRepository.deleteById(id);
        return "Deleted";
    }

    @Override
    @PutMapping("/experience/{id}")
    @SneakyThrows
    public Experience update(@PathVariable Long id, @RequestBody Experience body) {
        return experinceRepository.findById(id)
                .map(result -> {
                    result.setName(body.getName());
                    result.setDescription(body.getDescription());
                    result.setPlace(body.getPlace());
                    result.setYearStart(body.getYearStart());
                    result.setYearFinish(body.getYearFinish());
                    result.setPosition(body.getPosition());
                    return experinceRepository.save(result);
                }).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @Override
    @GetMapping("/experience")
    public List<Experience> all() {
        List<Experience> experiences = new ArrayList<>();
        experinceRepository.findAll().forEach(experiences::add);
        return experiences;
    }

    @Override
    @GetMapping("/experience/{id}")
    @SneakyThrows
    public Experience byId(@PathVariable Long id) {
        return experinceRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
