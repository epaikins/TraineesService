package org.amalitech.traineesservice.dto;

import java.time.LocalDate;

import org.amalitech.traineesservice.enums.BatchStatus;

import lombok.Data;

@Data
public class BatchDTO {
	private String name;
	private BatchStatus batchStatus = BatchStatus.inactivated;
	private LocalDate beginningDate;
	private LocalDate endingDate;
}
