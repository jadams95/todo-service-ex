package com.jadams.todoservice.repository;

import com.jadams.todoservice.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
}
