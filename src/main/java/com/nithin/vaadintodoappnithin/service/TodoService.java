package com.nithin.vaadintodoappnithin.service;

import java.util.List;
import java.util.Optional;

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

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Optional<Todo> findById(Long id) {
		return repository.findById(id);
	}

}