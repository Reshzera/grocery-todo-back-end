package com.example.grocery_todo_back_end.service;

import com.example.grocery_todo_back_end.dto.todoList.CreateTodoListDto;
import com.example.grocery_todo_back_end.dto.todoList.UpdateTodoListDto;
import com.example.grocery_todo_back_end.entity.TodoList;
import com.example.grocery_todo_back_end.errors.NotFoundError;
import com.example.grocery_todo_back_end.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TodoListService {
    @Autowired
    private TodoListRepository todoListRepository;

    public TodoList createList(CreateTodoListDto newList) {
        TodoList createdList = new TodoList(newList.name);
        return todoListRepository.save(createdList);
    }

    public List<TodoList> getAllLists() {
        return StreamSupport.stream(todoListRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public TodoList getListById(String id) {
        return todoListRepository.findById(id)
                .orElseThrow(() -> new NotFoundError("TodoList not found"));
    }

    public TodoList updateList(String id, UpdateTodoListDto updateDto) {
        TodoList existingList = todoListRepository.findById(id)
                .orElseThrow(() -> new NotFoundError("TodoList not found"));

        existingList.name = updateDto.name;

        return todoListRepository.save(existingList);
    }

    public void deleteList(String id) {
        TodoList existingList = todoListRepository.findById(id)
                .orElseThrow(() -> new NotFoundError("TodoList not found"));

        todoListRepository.delete(existingList);
    }
}
