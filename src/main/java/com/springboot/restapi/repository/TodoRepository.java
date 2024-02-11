package com.springboot.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.restapi.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
	public Todo getTodoById(int id);
}
