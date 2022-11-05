package com.organizationapp.cl.persintence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.organizationapp.cl.persintence.entities.Task;
import com.organizationapp.cl.persintence.entities.TaskStatus;

public interface ITaskRepository extends JpaRepository<Task, Long>{

	public List<Task> findAllByTaskStatus(TaskStatus taskStatus);
	
	@Modifying
	@Query(value = "Update Task set finished = true where id =:id", nativeQuery = true)
	public void markTaskAsFinished(@Param("id") Long id);
	
}
