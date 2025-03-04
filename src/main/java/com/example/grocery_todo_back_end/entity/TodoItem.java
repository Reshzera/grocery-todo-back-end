package com.example.grocery_todo_back_end.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private Boolean checked;


    public TodoItem(String name, Boolean checked) {
        this.name = name;
        this.checked = checked;
    }

}
