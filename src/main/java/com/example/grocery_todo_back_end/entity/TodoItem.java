package com.example.grocery_todo_back_end.entity;

import jakarta.persistence.*;

@Entity
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String id;
    public String name;
    public Boolean checked;

    @ManyToOne
    @JoinColumn(name = "todo_list_id", nullable = false)
    public TodoList todoList;


    //TODO remove this contructor
    public TodoItem(String name, Boolean checked) {
        this.name = name;
        this.checked = checked;
    }

    public TodoItem(String name, Boolean checked, TodoList todoList) {
        this.name = name;
        this.checked = checked;
        this.todoList = todoList;
    }
}
