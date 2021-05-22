package org.amalitech.traineesservice.dto;

import java.util.List;

import org.amalitech.traineesservice.entity.Trainee;

import lombok.Data;

@Data
public class TrackDTO {
	private Integer id;
	private String name;
	private String code;
	private List<Trainee> trainees;
}
