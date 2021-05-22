package org.amalitech.traineesservice.repository;

import java.util.List;

import org.amalitech.traineesservice.entity.TraineeTrack;
import org.amalitech.traineesservice.entity.TraineeTrackId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TraineeTrackRepository extends JpaRepository<TraineeTrack, TraineeTrackId> {
	@Query(value = "SELECT tt.track_id FROM db_trainee_service.trainee_tracks tt JOIN db_trainee_service.track t ON tt.track_id = t.id WHERE tt.trainee_id =:traineeId", nativeQuery = true)
	List<Integer> getTracksWithTrainee(@Param("traineeId") int traineeId);

	@Query(value = "SELECT tt.trainee_id FROM db_trainee_service.trainee_tracks tt JOIN db_trainee_service.track t ON tt.track_id = t.id WHERE tt.track_id =:trackId", nativeQuery = true)
	List<Integer> getTraineeWithTracks(@Param("trackId") int trackId);

}
