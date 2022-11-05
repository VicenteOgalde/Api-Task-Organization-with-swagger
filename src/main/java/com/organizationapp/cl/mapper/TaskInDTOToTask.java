package com.organizationapp.cl.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.organizationapp.cl.persintence.entities.Task;
import com.organizationapp.cl.persintence.entities.TaskStatus;
import com.organizationapp.cl.service.dto.TaskInDTO;
@Component
public class TaskInDTOToTask implements IMapper<TaskInDTO, Task> {

	@Override
	public Task map(TaskInDTO in) {

		Task task = new Task();
		task.setTitle(in.getTitle());
		task.setDescription(in.getDescription());
		task.setEta(in.getEta());
		task.setCreatedAt(LocalDateTime.now());
		task.setFinished(false);
		task.setTaskStatus(TaskStatus.ON_TIME);
		
		
		return task;
	}

}
