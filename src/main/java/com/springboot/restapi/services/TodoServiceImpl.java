package com.springboot.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.restapi.model.Todo;
import com.springboot.restapi.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoRepository todoRepository;

	@Override
	public int addTodo(Todo todo) {
		// TODO Auto-generated method stub
		Todo save = todoRepository.save(todo);
		if (save != null) {
			return 1;
		}
		return 0;
	}

	@Override
	public Todo getTodoById(int id) {
		// TODO Auto-generated method stub
		Todo todoById = todoRepository.getTodoById(id);
		return todoById;
	}

	@Override
	public int updateTodo(Todo todo) {
		// TODO Auto-generated method stub
		Todo todoDb = todoRepository.getTodoById(todo.getId());
		todoDb.setDescription(todo.getDescription());
		todoDb.setTargetDate(todo.getTargetDate());
		todoDb.setDone(todo.isDone());
		if (todoRepository.save(todoDb) != null) {
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteTodoById(int id) {
		// TODO Auto-generated method stub
		if (todoRepository.getTodoById(id) == null) {
			return 0;
		}
		todoRepository.deleteById(id);
		return 1;
	}

	@Override
	public List<Todo> getAllTodos(String username) {
		// TODO Auto-generated method stub
		List<Todo> allTodos = todoRepository.findAll();
		return allTodos.stream().filter(todo -> todo.getUsername().equalsIgnoreCase(username)).toList();
	}
}