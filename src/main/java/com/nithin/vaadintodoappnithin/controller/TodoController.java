package com.nithin.vaadintodoappnithin.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nithin.vaadintodoappnithin.entity.Todo;
import com.nithin.vaadintodoappnithin.service.TodoService;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

	private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return service.findAll();
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return service.save(todo);
    }
}
