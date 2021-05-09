package org.amalitech.traineesservice.dto;

import java.time.LocalDate;

import org.amalitech.traineesservice.entity.Batch;
import org.amalitech.traineesservice.entity.Track;
import org.amalitech.traineesservice.enums.TraineeStatus;

import lombok.Data;

@Data
public class TraineeDTO {
	private Integer id;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private Track track;
	private Batch batch;
	private TraineeStatus status = TraineeStatus.created;
}
