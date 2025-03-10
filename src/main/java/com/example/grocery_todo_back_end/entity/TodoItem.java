package com.example.grocery_todo_back_end.entity;

import jakarta.persistence.*;

@Entity
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String id;
    public String name;
    public Boolean checked;

    public TodoItem() {
    }

    public TodoItem(String name, Boolean checked) {
        this.name = name;
        this.checked = checked;
    }
}
