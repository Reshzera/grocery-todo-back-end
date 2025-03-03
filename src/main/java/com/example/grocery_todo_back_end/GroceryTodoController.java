package com.example.grocery_todo_back_end;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroceryTodoController {
	private final GroceryTodoService groceryService;
	GroceryTodoController(GroceryTodoService groceryService){
		this.groceryService = groceryService;
	}
	@GetMapping("/")
	public String index() {
		this.groceryService.createItem();
		return "Hello world";
	}
}