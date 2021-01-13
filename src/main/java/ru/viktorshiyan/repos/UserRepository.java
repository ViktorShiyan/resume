package ru.viktorshiyan.repos;

import org.springframework.data.repository.CrudRepository;

import ru.viktorshiyan.domain.Person;


public interface UserRepository extends CrudRepository<Person, Integer> {

}
