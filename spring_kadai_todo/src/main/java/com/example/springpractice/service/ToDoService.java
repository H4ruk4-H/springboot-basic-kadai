package com.example.springpractice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springpractice.entity.ToDo;
import com.example.springpractice.repository.ToDoRepository;

@Service
public class ToDoService {
	private final ToDoRepository todoRepository;
	
	public ToDoService(ToDoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	public List<ToDo> getAllToDos(){
		return todoRepository.findAll();
	}
}
