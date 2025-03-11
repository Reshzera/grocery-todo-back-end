package com.example.grocery_todo_back_end.controller;

import com.example.grocery_todo_back_end.dto.todoList.CreateTodoListDto;
import com.example.grocery_todo_back_end.dto.todoList.TodoListResponseDto;
import com.example.grocery_todo_back_end.dto.todoList.UpdateTodoListDto;
import com.example.grocery_todo_back_end.entity.TodoList;
import com.example.grocery_todo_back_end.service.TodoListService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/todo-lists")
public class TodoListController {
    @Autowired
    private TodoListService todoListService;

    @PostMapping
    public ResponseEntity<TodoListResponseDto> createList(@Valid @RequestBody CreateTodoListDto newList) {
        TodoList list = todoListService.createList(newList);
        return ResponseEntity.status(201).body(new TodoListResponseDto(list));
    }

    @GetMapping
    public ResponseEntity<List<TodoListResponseDto>> getAllLists() {
        List<TodoListResponseDto> lists = todoListService.getAllLists()
                .stream()
                .map(TodoListResponseDto::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(lists);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoListResponseDto> getListById(@PathVariable String id) {
        TodoList list = todoListService.getListById(id);
        return ResponseEntity.ok(new TodoListResponseDto(list));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoListResponseDto> updateList(@PathVariable String id, @Valid @RequestBody UpdateTodoListDto updateDto) {
        TodoList updatedList = todoListService.updateList(id, updateDto);
        return ResponseEntity.ok(new TodoListResponseDto(updatedList));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteList(@PathVariable String id) {
        todoListService.deleteList(id);
        return ResponseEntity.noContent().build();
    }
}
