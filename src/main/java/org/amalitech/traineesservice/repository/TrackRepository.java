package org.amalitech.traineesservice.repository;

import java.util.List;

import org.amalitech.traineesservice.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface TrackRepository extends JpaRepository<Track,Integer> {
	
//	@Query(value="SELECT * FROM track t WHERE t.id IN (SELECT track_id FROM trainee_tracks)", nativeQuery=true)
//	List<Track> getTracksWithTrainee();
	
}
