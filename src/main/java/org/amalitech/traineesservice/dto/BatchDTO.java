package org.amalitech.traineesservice.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BatchDTO {
	private String name;
	private LocalDate beginningDate;
	private LocalDate endingDate;
}
