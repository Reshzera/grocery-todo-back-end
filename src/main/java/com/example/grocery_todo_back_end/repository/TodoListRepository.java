package com.example.grocery_todo_back_end.repository;

import com.example.grocery_todo_back_end.entity.TodoList;
import org.springframework.data.repository.CrudRepository;

public interface TodoListRepository extends CrudRepository<TodoList, String> {
}
