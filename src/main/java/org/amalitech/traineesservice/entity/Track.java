package org.amalitech.traineesservice.entity;

import javax.persistence.Entity;
import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Track {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true)
	private String name;
	
	@Column(unique = true)
	private String code;
	
	private Boolean isSuspended = false;
}
