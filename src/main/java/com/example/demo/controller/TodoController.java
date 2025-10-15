package com.example.demo.controller;

import com.example.demo.entity.Todo;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todo")
    public List<Todo> getTodo(){
        return todoService.getTodo();
    }

    @PostMapping("/todo")
    public Todo createTodo(Todo todo){
        return todoService.createTodo(todo);
    }

    @GetMapping("/todo/{todoId}")
    public Todo getTodoById(@PathVariable Long todoId){
        return todoService.getTodoById(todoId);
    }
}
