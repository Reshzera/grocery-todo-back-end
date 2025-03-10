package com.example.grocery_todo_back_end.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String id;

    public String name;

    @OneToMany(mappedBy = "todoList", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<TodoItem> items;
}
