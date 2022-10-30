package com.emrah.todolist.repository;

import com.emrah.todolist.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findByDoneIsFalse();
    List<Todo> findByDoneIsTrue();
}
