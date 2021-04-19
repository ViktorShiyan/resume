package ru.viktorshiyan.controllers;

import ru.viktorshiyan.domain.Experience;

import java.util.List;

public interface CrudController<T> {
    public T create(T body);

    public String delete(Long id);

    public T update(Long id, T body);

    public List<T> all();

    public T byId(Long id);
}
