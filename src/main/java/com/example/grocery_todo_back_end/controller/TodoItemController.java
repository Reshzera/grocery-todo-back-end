package com.example.grocery_todo_back_end.controller;

import com.example.grocery_todo_back_end.dto.CreateTodoItemDto;
import com.example.grocery_todo_back_end.dto.TodoItemResponseDto;
import com.example.grocery_todo_back_end.dto.UpdateTodoItemDto;
import com.example.grocery_todo_back_end.entity.TodoItem;
import com.example.grocery_todo_back_end.service.TodoItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/todo")
public class TodoItemController {
    @Autowired
    private TodoItemService todoItemService;

    @PostMapping("/")
    public ResponseEntity<TodoItemResponseDto> createItem(@Valid @RequestBody CreateTodoItemDto newTodoItem) {
        TodoItem item = todoItemService.createItem(newTodoItem);
        return ResponseEntity.status(201).body(new TodoItemResponseDto(item));
    }

    @GetMapping("/")
    public ResponseEntity<List<TodoItemResponseDto>> getAllItems() {
        List<TodoItemResponseDto> items = todoItemService.getAllItems()
                .stream()
                .map(TodoItemResponseDto::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoItemResponseDto> getItemById(@PathVariable String id) {
        TodoItem item = todoItemService.getItemById(id);
        return ResponseEntity.ok(new TodoItemResponseDto(item));
    }


    @PutMapping("/{id}")
    public ResponseEntity<TodoItemResponseDto> updateItem(@PathVariable String id, @Valid @RequestBody UpdateTodoItemDto updateDto) {
        TodoItem updatedItem = todoItemService.updateItem(id, updateDto);
        return ResponseEntity.ok(new TodoItemResponseDto(updatedItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable String id) {
        todoItemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}