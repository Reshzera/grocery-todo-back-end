package com.example.grocery_todo_back_end.service;

import com.example.grocery_todo_back_end.dto.CreateTodoItemDto;
import com.example.grocery_todo_back_end.entity.TodoItem;
import com.example.grocery_todo_back_end.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoItemService {
    @Autowired
    private TodoItemRepository todoListRepository;

    public void createItem(CreateTodoItemDto newTodo) {
        TodoItem createdItem = new TodoItem(newTodo.name, newTodo.checked);
        this.todoListRepository.save(createdItem);
    }
}
