package com.nithin.vaadintodoappnithin.view;

import java.util.List;

import com.nithin.vaadintodoappnithin.entity.Todo;
import com.nithin.vaadintodoappnithin.presenter.TodoPresenter;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {
    private final TodoPresenter presenter;
    private Grid<Todo> grid;
    private TextField newTodoText;
    private Button addTodoButton;

    public MainView(TodoPresenter presenter) {
        this.presenter = presenter;
        this.grid = new Grid<>(Todo.class);
        this.newTodoText = new TextField();
        this.addTodoButton = new Button("Add");

        addTodoButton.addClickListener(e -> presenter.save(new Todo(newTodoText.getValue())));
        add(grid, newTodoText, addTodoButton);

        presenter.setView(this);
    }

    public void updateList(List<Todo> todos) {
        grid.setItems(todos);
    }
}