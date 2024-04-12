package com.nithin.vaadintodoappnithin.presenter;

import java.util.List;

import org.springframework.stereotype.Component;

import com.nithin.vaadintodoappnithin.controller.TodoController;
import com.nithin.vaadintodoappnithin.entity.Todo;
import com.nithin.vaadintodoappnithin.view.MainView;
import com.vaadin.flow.component.notification.Notification;

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
		Notification.show("Todo added successfully!!");
	}

	public void updateView() {
		List<Todo> todos = controller.getAllTodos();
		view.updateList(todos);
	}
	
	// TodoPresenter.java
	public void delete(Long id) {
	    controller.deleteTodo(id);
	    updateView();
	    Notification.show("Todo deleted successfully!!");
	}
	
	  public void updateStatus(Long id, boolean done) {
	        Todo todo = controller.getTodoById(id);
	        if (todo != null) {
	            todo.setDone(done);
	            controller.updateTodo(todo);
	            updateView();
	        }
	    }

}
