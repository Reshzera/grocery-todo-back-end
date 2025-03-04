package com.example.grocery_todo_back_end.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateTodoItemDto {
    @NotBlank(message = "Name is mandatory")
    public String name;

    @NotNull(message = "checked is mandatory")
    public boolean checked;
}
