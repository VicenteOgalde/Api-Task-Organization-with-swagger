package com.organizationapp.cl.service;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.organizationapp.cl.exceptions.TaskException;
import com.organizationapp.cl.mapper.TaskInDTOToTask;
import com.organizationapp.cl.persintence.entities.Task;
import com.organizationapp.cl.persintence.entities.TaskStatus;
import com.organizationapp.cl.persintence.repositories.ITaskRepository;
import com.organizationapp.cl.service.dto.TaskInDTO;

@Service
public class TaskService {
	
	private final ITaskRepository taskRepository ;
	private final TaskInDTOToTask taskInDTOToTask;
	
	public TaskService(ITaskRepository taskRepository,TaskInDTOToTask taskInDTOToTask) {
		this.taskRepository=taskRepository;
		this.taskInDTOToTask=taskInDTOToTask;
	}
	
	public Task createTask(TaskInDTO taskInDTO) {
		return taskRepository.save(taskInDTOToTask.map(taskInDTO));
	}

	public List<Task> findAllTask(){
		return taskRepository.findAll();
	}
	public List<Task> findAllTaskByStatus(TaskStatus taskStatus){
		return taskRepository.findAllByTaskStatus(taskStatus);
	}
	@Transactional
	public void updateTaskAsFinished(Long id) {
		Optional<Task> optionalTask= taskRepository.findById(id);
		if(optionalTask.isEmpty()) {
			throw new TaskException("Task not Found", HttpStatus.NOT_FOUND);
		}
		taskRepository.markTaskAsFinished(id);
	}
	public void deleteTask(Long id) {
		Optional<Task> optionalTask= taskRepository.findById(id);
		if(optionalTask.isEmpty()) {
			throw new TaskException("Task not Found", HttpStatus.NOT_FOUND);
		}
		taskRepository.deleteById(id);
	}
}
