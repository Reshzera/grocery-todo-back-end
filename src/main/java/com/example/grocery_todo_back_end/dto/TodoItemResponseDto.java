package com.example.grocery_todo_back_end.dto;

import com.example.grocery_todo_back_end.entity.TodoItem;

public class TodoItemResponseDto {
    public String id;
    public String name;
    public Boolean checked;

    public TodoItemResponseDto(TodoItem item) {
        this.id = item.id;
        this.name = item.name;
        this.checked = item.checked;
    }
}
