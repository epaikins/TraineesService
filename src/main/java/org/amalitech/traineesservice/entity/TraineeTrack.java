package org.amalitech.traineesservice.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "trainee_tracks")
public class TraineeTrack {
	@EmbeddedId
	private TraineeTrackId id;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("traineeId")
	@JoinColumn(name = "trainee_id")
	private Trainee trainee;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("trackId")
	@JoinColumn(name = "track_id")
	private Track track;
	
	@CreationTimestamp
	private LocalDateTime joinedDate;
	
	public TraineeTrack(Trainee trainee, Track track) {
        this.id = new TraineeTrackId(trainee.getId(), track.getId());
        this.trainee = trainee;
        this.track = track;
    }
}
