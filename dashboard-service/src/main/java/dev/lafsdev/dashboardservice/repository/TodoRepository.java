package dev.lafsdev.dashboardservice.repository;

import dev.lafsdev.dashboardservice.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
}
