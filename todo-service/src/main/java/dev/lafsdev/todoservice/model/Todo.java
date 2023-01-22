package dev.lafsdev.todoservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

public record Todo(Integer userId, @Id Integer id, String title, boolean completed, @Version Integer version) {
}
