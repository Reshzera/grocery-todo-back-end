package com.example.grocery_todo_back_end.dto.todoList;

import com.example.grocery_todo_back_end.entity.TodoItem;
import com.example.grocery_todo_back_end.entity.TodoList;

import java.util.List;

public class TodoListResponseDto {
    public String id;
    public String name;
    public List<TodoItem> items;

    public TodoListResponseDto(TodoList todoList) {
        this.id = todoList.id;
        this.name = todoList.name;
        this.items = todoList.items;
    }
}
