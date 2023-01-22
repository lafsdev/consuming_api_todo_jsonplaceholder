package dev.lafsdev.todoservice.repository;

import dev.lafsdev.todoservice.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
}
