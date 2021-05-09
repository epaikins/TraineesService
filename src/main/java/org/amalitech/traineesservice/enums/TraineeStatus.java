package org.amalitech.traineesservice.enums;

import lombok.Getter;

@Getter
public enum TraineeStatus {
	created("CREATED"), activated("ACTIVATED"), suspended("SUSPENDED"), completed("COMPLETED");
	
	private String traineeStatus;
	
	private TraineeStatus(String traineeStatus) {
		this.traineeStatus = traineeStatus;
	}
}
