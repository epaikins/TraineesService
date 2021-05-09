package org.amalitech.traineesservice.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.amalitech.traineesservice.enums.TraineeStatus;

import lombok.Data;

@Entity
@Data
public class Trainee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	
	@ManyToOne
	@JoinColumn(name = "track_id")
	private Track track;
	
	@ManyToOne
	@JoinColumn(name = "batch_id")
	private Batch batch;
	
	@Enumerated(EnumType.STRING)
	private TraineeStatus status = TraineeStatus.created;
}

