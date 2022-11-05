package com.organizationapp.cl.service.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskInDTO {
	
	

	private String title;
	private String description;
	private LocalDateTime eta;


}
