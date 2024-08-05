package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping("/items")
    public ResponseEntity<List<Todo>> getTodo(){
        return new ResponseEntity<>(service.getTodo(), HttpStatus.OK);
    }
    @PostMapping("/item")
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo){
        return new ResponseEntity<>(service.addTodo(todo),HttpStatus.OK);
    }
    @GetMapping("/item/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id){
        Todo todo = service.getTodoById(id);
        if (todo != null)
            return new ResponseEntity<>(service.getTodoById(id),HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/items/{id}")
    public ResponseEntity<String> updateTod(@PathVariable Long id, @RequestBody Todo todo){
        Todo todo1 = null;
        todo1 = service.updateTodo(id,todo);
        if (todo1!= null)
            return new ResponseEntity<>("Updated",HttpStatus.OK);
        else
            return new ResponseEntity<>("Failes to Update",HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/items/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id){
        Todo todo = service.getTodoById(id);

        if (todo!= null){
            service.deleteTodo(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);}
        else
            return new ResponseEntity<>("Failed ", HttpStatus.BAD_REQUEST);
    }

}
