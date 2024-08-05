package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repo.Todorepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private Todorepo repo;

    public List<Todo> getTodo(){
        return repo.findAll();
    }
    public Todo getTodoById(Long id){
        return repo.findById(id).orElse(null);
    }
    public Todo updateTodo(long id ,Todo todo){
        return repo.save(todo);
    }
    public Todo addTodo(Todo todo){
        return repo.save(todo);
    }
    public void deleteTodo(Long id){
        repo.deleteById(id);
    }
}
