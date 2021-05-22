package org.amalitech.traineesservice.enums;

public enum BatchStatus {
	inactivated("INACTIVATED"), activated("ACTIVATED"), completed("COMPLETED");

	private String batchStatus;

	private BatchStatus(String batchStatus) {
		this.batchStatus = batchStatus;
	}
}
