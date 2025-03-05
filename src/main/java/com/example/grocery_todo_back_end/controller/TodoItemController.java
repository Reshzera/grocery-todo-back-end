package com.example.grocery_todo_back_end.controller;

import com.example.grocery_todo_back_end.dto.CreateTodoItemDto;
import com.example.grocery_todo_back_end.entity.TodoItem;
import com.example.grocery_todo_back_end.service.TodoItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoItemController {
    @Autowired
    private TodoItemService groceryService;

    @PostMapping("/")
    public ResponseEntity<TodoItem> createItem(@Valid @RequestBody CreateTodoItemDto newTodoITem) {
        TodoItem item = this.groceryService.createItem(newTodoITem);
        return new ResponseEntity<TodoItem>(item, HttpStatus.CREATED);
    }
}