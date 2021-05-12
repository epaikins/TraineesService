package org.amalitech.traineesservice.api;

import java.util.List;

import org.amalitech.traineesservice.dto.TrackDTO;
import org.amalitech.traineesservice.entity.Track;
import org.amalitech.traineesservice.entity.Trainee;
import org.amalitech.traineesservice.service.TrackService;
import org.amalitech.traineesservice.service.TraineeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TrackController {
	@Autowired
	private TrackService trackService;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@GetMapping("/tracks")
	public List<Track> getTracks(){
		return trackService.getTracks();
	}
	
	@PostMapping("/track")
	public Track createTrack(@RequestBody TrackDTO trackDTO) {
		Track track = modelmapper.map(trackDTO, Track.class);
		
		return trackService.createTrack(track);
	}
	
	@PutMapping("/track/{id}")
	public Track updateTrack(@PathVariable(name="id") Integer id, @RequestBody TrackDTO trackDTO) {
		Track track = modelmapper.map(trackDTO, Track.class);
		return trackService.updateTrack(id, track);
	}
	
	@DeleteMapping("/track/{id}")
	public void deleteTrack(@PathVariable(name="id") Integer id) {
		trackService.deleteTrack(id);
	}
	
	@PutMapping("/track/{trackId}/trainee/{traineeId}")
	public void enrollTraineeToTrack(@PathVariable Integer trackId, @PathVariable Integer traineeId) {
		trackService.enrollTraineeToTrack(trackId, traineeId);
	}
}
