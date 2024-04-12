package com.nithin.vaadintodoappnithin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nithin.vaadintodoappnithin.entity.Todo;
import com.nithin.vaadintodoappnithin.repo.TodoRepository;

@Service
public class TodoService {
	private TodoRepository repository;

	public TodoService(TodoRepository repository) {
		this.repository = repository;
	}

	public List<Todo> findAll() {
		return repository.findAll();
	}

	public Todo save(Todo todo) {
		return repository.save(todo);
	}
}