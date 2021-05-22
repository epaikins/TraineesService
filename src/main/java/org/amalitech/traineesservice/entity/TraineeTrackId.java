package org.amalitech.traineesservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class TraineeTrackId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8489137992225802185L;

	@Column(name = "trainee_id")
	private Integer traineeId;

	@Column(name = "track_id")
	private Integer trackId;

}
