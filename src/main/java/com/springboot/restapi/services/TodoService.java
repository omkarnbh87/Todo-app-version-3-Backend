package com.springboot.restapi.services;

import java.util.List;

import com.springboot.restapi.model.Todo;

public interface TodoService {

	int addTodo(Todo todo);

	Todo getTodoById(int id);

	int updateTodo(Todo todo);

	int deleteTodoById(int id);

	List<Todo> getAllTodos(String username);
}
