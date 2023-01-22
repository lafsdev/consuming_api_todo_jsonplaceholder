package dev.lafsdev.todoservice;

import dev.lafsdev.todoservice.model.Todo;
import dev.lafsdev.todoservice.repository.TodoRepository;
import dev.lafsdev.todoservice.service.JsonPlaceholderService;
import dev.lafsdev.todoservice.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class TodoServiceApplication {

	private static final Logger log = LoggerFactory.getLogger(TodoServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TodoServiceApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
	@Bean
		CommandLineRunner commandLineRunner(JsonPlaceholderService jsonPlaceholderService, TodoRepository repository, TodoService service){
		return args -> {
			List<Todo> todos = jsonPlaceholderService.getTodos();

			repository.saveAll(todos);
			log.info("Saved {} todos in the database", todos.size());

			service.sendToDashboard(todos);
		};
	}

}
