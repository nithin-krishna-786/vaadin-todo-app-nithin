package com.nithin.vaadintodoappnithin.presenter;

import java.util.List;

import org.springframework.stereotype.Component;

import com.nithin.vaadintodoappnithin.controller.TodoController;
import com.nithin.vaadintodoappnithin.entity.Todo;
import com.nithin.vaadintodoappnithin.view.MainView;

@Component
public class TodoPresenter {
	private final TodoController controller;
	private MainView view;

	public TodoPresenter(TodoController controller) {
		this.controller = controller;
	}

	public void setView(MainView view) {
		this.view = view;
		updateView();
	}

	public void save(Todo todo) {
		controller.createTodo(todo);
		updateView();
	}

	public void updateView() {
		List<Todo> todos = controller.getAllTodos();
		view.updateList(todos);
	}
}
