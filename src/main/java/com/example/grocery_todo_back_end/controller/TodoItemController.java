package com.example.grocery_todo_back_end.controller;

import com.example.grocery_todo_back_end.dto.CreateTodoItemDto;
import com.example.grocery_todo_back_end.service.TodoItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void createItem(@Valid @RequestBody CreateTodoItemDto newTodoITem) {
        this.groceryService.createItem(newTodoITem);
    }
}