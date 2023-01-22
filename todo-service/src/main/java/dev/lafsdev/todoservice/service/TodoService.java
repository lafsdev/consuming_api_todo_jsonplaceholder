package dev.lafsdev.todoservice.service;

import dev.lafsdev.todoservice.model.Todo;
import dev.lafsdev.todoservice.repository.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TodoService {

    private static final Logger LOG = LoggerFactory.getLogger(TodoService.class);
    private final String DASHBOARD_API_URL = "http://localhost:8081/api/dashboard/todos";
    private TodoRepository repository;
    private final RestTemplate restTemplate;

    public TodoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public void sendToDashboard(List<Todo> todos) {
        ResponseEntity<String> response = restTemplate.postForEntity(DASHBOARD_API_URL, todos, String.class);
        if(response.getStatusCode().is2xxSuccessful()){
            LOG.info("Todos sent to dashboard successfuly");
        }
    }
}
