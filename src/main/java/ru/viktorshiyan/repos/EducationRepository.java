package ru.viktorshiyan.repos;

import org.springframework.data.repository.CrudRepository;
import ru.viktorshiyan.domain.Education;

public interface EducationRepository extends CrudRepository<Education, Long> {
}
