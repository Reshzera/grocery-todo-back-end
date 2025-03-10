package com.example.grocery_todo_back_end.service;

import com.example.grocery_todo_back_end.dto.CreateTodoItemDto;
import com.example.grocery_todo_back_end.dto.UpdateTodoItemDto;
import com.example.grocery_todo_back_end.entity.TodoItem;
import com.example.grocery_todo_back_end.errors.NotFoundError;
import com.example.grocery_todo_back_end.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TodoItemService {
    @Autowired
    private TodoItemRepository todoItemRepository;

    public TodoItem createItem(CreateTodoItemDto newTodo) {
        TodoItem createdItem = new TodoItem(newTodo.name, newTodo.checked);
        return todoItemRepository.save(createdItem);
    }

    public List<TodoItem> getAllItems() {
        return StreamSupport.stream(todoItemRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public TodoItem getItemById(String id) {
        return todoItemRepository.findById(id)
                .orElseThrow(() -> new NotFoundError("Item not found"));
    }

    public TodoItem updateItem(String id, UpdateTodoItemDto updateDto) {
        TodoItem existingItem = todoItemRepository.findById(id)
                .orElseThrow(() -> new NotFoundError("Item not found"));

        existingItem.name = updateDto.name;
        existingItem.checked = updateDto.checked;

        return todoItemRepository.save(existingItem);
    }

    public void deleteItem(String id) {
        TodoItem existingItem = todoItemRepository.findById(id)
                .orElseThrow(() -> new NotFoundError("Item not found"));

        todoItemRepository.delete(existingItem);
    }
}
