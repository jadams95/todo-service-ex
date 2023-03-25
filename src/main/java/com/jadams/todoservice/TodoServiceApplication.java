package com.jadams.todoservice;

import com.jadams.todoservice.model.Todo;
import com.jadams.todoservice.repository.TodoRepository;
import com.jadams.todoservice.service.JsonPlaceholderService;
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

    private static final Logger LOG = LoggerFactory.getLogger(TodoServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TodoServiceApplication.class, args);
    }


    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    CommandLineRunner commandLineRunner(JsonPlaceholderService jsonPlaceholderService, TodoRepository todoRepository){
        return args -> {
            List<Todo> todos = jsonPlaceholderService.getTodos();
            LOG.info("Saved {} todos in the database", todos.size());
            todoRepository.saveAll(todos);
        };
    }

}
