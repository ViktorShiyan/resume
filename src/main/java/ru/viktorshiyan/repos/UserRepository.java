package ru.viktorshiyan.repos;

import org.springframework.data.repository.CrudRepository;

import ru.viktorshiyan.domain.Person;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<Person, Integer> {

}
