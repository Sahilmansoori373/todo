package com.example.todo.repo;

import com.example.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Todorepo extends JpaRepository<Todo,Long> {

}
