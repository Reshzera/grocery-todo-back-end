package com.example.grocery_todo_back_end.dto.todoList;

import jakarta.validation.constraints.NotBlank;

public class CreateTodoListDto {
    @NotBlank(message = "Name is mandatory")
    public String name;
}
