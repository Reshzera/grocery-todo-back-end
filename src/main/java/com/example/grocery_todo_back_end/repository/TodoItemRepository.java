package com.example.grocery_todo_back_end.repository;

import com.example.grocery_todo_back_end.entity.TodoItem;
import org.springframework.data.repository.CrudRepository;

public interface TodoItemRepository extends CrudRepository<TodoItem, Integer> {
}
