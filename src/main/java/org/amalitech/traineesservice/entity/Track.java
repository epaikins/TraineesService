package org.amalitech.traineesservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

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
