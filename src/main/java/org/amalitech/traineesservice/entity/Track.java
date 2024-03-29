package org.amalitech.traineesservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Track {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

//	@JsonIgnore
//	@OneToMany(mappedBy = "track")
//	private Set<TraineeTrack> traineeTracks = new HashSet<>();

	@Column(unique = true)
	private String name;

	@Column(unique = true)
	private String code;

	private Boolean isSuspended = false;
}
