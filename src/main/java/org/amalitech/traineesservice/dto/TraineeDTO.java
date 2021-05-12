package org.amalitech.traineesservice.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.amalitech.traineesservice.entity.Batch;
import org.amalitech.traineesservice.entity.Track;
import org.amalitech.traineesservice.entity.TraineeTrack;
import org.amalitech.traineesservice.enums.TraineeStatus;

import lombok.Data;

@Data
public class TraineeDTO {
	private Integer id;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private List<Track> tracks;
//	private Track track;
	private Batch batch;
	private TraineeStatus status = TraineeStatus.created;
}
