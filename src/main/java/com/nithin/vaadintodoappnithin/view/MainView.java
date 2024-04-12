package com.nithin.vaadintodoappnithin.view;

import java.util.List;

import com.nithin.vaadintodoappnithin.entity.Todo;
import com.nithin.vaadintodoappnithin.presenter.TodoPresenter;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {
    private final TodoPresenter presenter;
    private Grid<Todo> grid;
    private TextField newTodoText;
    private Button addTodoButton;
    private HorizontalLayout hl;

    public MainView(TodoPresenter presenter) {
        this.presenter = presenter;
        
        // Create the title
        H1 title = new H1("TODO List");
        title.getStyle().set("text-align", "center"); // Center the title

        // ... other initialization ...

        // Add the title and the grid to the layout
        add(title);
        setHorizontalComponentAlignment(Alignment.CENTER, title);
        
        this.grid = new Grid<>(Todo.class, false);
        grid.setWidth("70%");
        
        // Define the 'Text' column
        grid.addColumn(Todo::getText).setHeader("Text");
     // Center the grid in the layout
        setHorizontalComponentAlignment(Alignment.CENTER, grid);
        
        // Add the grid to the layout
        add(grid);
        
        // Define the 'Done' checkbox column
        grid.addComponentColumn(todo -> {
            Checkbox checkbox = new Checkbox(todo.isDone());
            checkbox.addValueChangeListener(event -> presenter.updateStatus(todo.getId(), event.getValue()));
            return checkbox;
        }).setHeader("Done");
        
        // Define the 'Action' column with delete button
        grid.addComponentColumn(todo -> {
            Button deleteButton = new Button("Delete", clickEvent -> presenter.delete(todo.getId()));
            return deleteButton;
        }).setHeader("Action");

        
        this.newTodoText = new TextField();
        this.addTodoButton = new Button("Add");
        
        addTodoButton.addClickListener(e -> presenter.save(new Todo(newTodoText.getValue())));
        
        hl = new HorizontalLayout();
        hl.add(newTodoText, addTodoButton);
        add(hl);
        
        setHorizontalComponentAlignment(Alignment.CENTER, hl);
        
        
        presenter.setView(this);
    }

    public void updateList(List<Todo> todos) {
        grid.setItems(todos);
    }
}