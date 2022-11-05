package com.organizationapp.cl.controllers;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organizationapp.cl.persintence.entities.Task;
import com.organizationapp.cl.persintence.entities.TaskStatus;
import com.organizationapp.cl.service.TaskService;
import com.organizationapp.cl.service.dto.TaskInDTO;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	
	private final TaskService taskService;
	
	public TaskController(TaskService taskService) {
		this.taskService=taskService;
	}
	@PostMapping
	public Task createTask(@RequestBody TaskInDTO taskInDTO) {
		return this.taskService.createTask(taskInDTO);
	}
	@GetMapping
	public List<Task> findAllTask(){
		return taskService.findAllTask();
	}
	@GetMapping("/status/{status}")
	public List<Task> findAllByStatus(@PathVariable("status") TaskStatus taskStatus){
		return taskService.findAllTaskByStatus(taskStatus);
	}
	@PatchMapping("/mark_as_finished/{id}")
	public ResponseEntity<Void> updatedTaskAsFinished(@PathVariable("id") Long id) {
		taskService.updateTaskAsFinished(id);
		return ResponseEntity.noContent().build();
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable("id") Long id) {
		taskService.deleteTask(id);
		return ResponseEntity.noContent().build();
	}
	

}
