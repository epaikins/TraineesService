package org.amalitech.traineesservice.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.amalitech.traineesservice.dto.TrackDTO;
import org.amalitech.traineesservice.entity.Track;
import org.amalitech.traineesservice.entity.Trainee;
import org.amalitech.traineesservice.repository.TraineeTrackRepository;
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
	private TraineeTrackRepository traineeTrackRepository;

	@Autowired
	private TraineeService traineeService;

	@Autowired
	private ModelMapper modelmapper;

	@GetMapping("/tracks")
	public List<Track> getTracks() {
		return trackService.getTracks();
	}

	@GetMapping("/track/{id}")
	public TrackDTO getTraineeById(@PathVariable int id) {
		Track track = trackService.getTrack(id);
		List<Integer> traineeIds = new ArrayList<>();
		traineeIds.addAll(traineeTrackRepository.getTraineeWithTracks(id));
		List<Trainee> trainees = traineeIds.stream().map(x -> traineeService.getTraineeById(x))
				.collect(Collectors.toList());

		TrackDTO trackDTO = modelmapper.map(track, TrackDTO.class);
		trackDTO.setTrainees(trainees);
		return trackDTO;
	}

	@PostMapping("/track")
	public Track createTrack(@RequestBody TrackDTO trackDTO) {
		Track track = modelmapper.map(trackDTO, Track.class);

		return trackService.createTrack(track);
	}

	@PutMapping("/track/{id}")
	public Track updateTrack(@PathVariable(name = "id") Integer id, @RequestBody TrackDTO trackDTO) {
		Track track = modelmapper.map(trackDTO, Track.class);
		return trackService.updateTrack(id, track);

	}

	@DeleteMapping("/track/{id}")
	public void deleteTrack(@PathVariable(name = "id") Integer id) {
		trackService.deleteTrack(id);
	}

	@PutMapping("/track/{trackId}/trainee/{traineeId}")
	public void enrollTraineeToTrack(@PathVariable Integer trackId, @PathVariable Integer traineeId) {
		trackService.enrollTraineeToTrack(trackId, traineeId);
	}
}
