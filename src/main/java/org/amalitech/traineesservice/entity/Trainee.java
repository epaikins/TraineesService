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

import lombok.Getter;
import lombok.Setter;

@Entity
//@Data
@Getter
@Setter
public class Trainee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;
	private LocalDate dob;

//	@JsonIgnore
//	@OneToMany(mappedBy = "trainee")
//	private Set<TraineeTrack> traineeTracks =  new HashSet<>();

//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "track_id")
//	private Track track;

	@ManyToOne
	@JoinColumn(name = "batch_id")
	private Batch batch;

	@Enumerated(EnumType.STRING)
	private TraineeStatus status = TraineeStatus.created;
}
