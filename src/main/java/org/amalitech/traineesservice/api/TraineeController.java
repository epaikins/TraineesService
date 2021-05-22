package org.amalitech.traineesservice.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.amalitech.traineesservice.dto.TraineeDTO;
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
public class TraineeController {

	@Autowired
	private TraineeService traineeService;

	@Autowired
	private TrackService trackService;

	@Autowired
	private TraineeTrackRepository traineeTrackRepository;

	@Autowired
	private ModelMapper modelmapper;

	@GetMapping("/trainees")
	public List<Trainee> getTrainees() {
		return traineeService.getTrainees();
	}

	@GetMapping("/trainee/{id}")
	public TraineeDTO getTraineeById(@PathVariable int id) {
		Trainee trainee = traineeService.getTraineeById(id);
		List<Integer> trackIds = new ArrayList<>();
		trackIds.addAll(traineeTrackRepository.getTracksWithTrainee(id));
		List<Track> tracks = trackIds.stream().map(x -> trackService.getTrack(x)).collect(Collectors.toList());

		TraineeDTO traineeDTO = modelmapper.map(trainee, TraineeDTO.class);
		traineeDTO.setTracks(tracks);
		return traineeDTO;
	}

	@GetMapping("/batch/{batchId}/trainees")
	public List<TraineeDTO> getAllTraineesByBatchId(@PathVariable(name = "batchId") Integer id) {
		return traineeService.getAllTraineesByBatchId(id).stream()
				.map(trainee -> modelmapper.map(trainee, TraineeDTO.class)).collect(Collectors.toList());
	}

	@GetMapping("/status/{status}/trainees")
	public List<TraineeDTO> getAllTraineesByBatchId(@PathVariable(name = "status") String status) {
		return traineeService.getAllTraineesByStatus(status).stream()
				.map(trainee -> modelmapper.map(trainee, TraineeDTO.class)).collect(Collectors.toList());
	}

	@PostMapping("/trainees")
	public Trainee createTrainee(@RequestBody TraineeDTO traineeDTO) {
		Trainee trainee = modelmapper.map(traineeDTO, Trainee.class);
		return traineeService.createTrainee(trainee);
	}

	@PutMapping("/trainee/{id}")
	public Trainee updateTrainee(@PathVariable(name = "id") Integer id, @RequestBody TraineeDTO traineeDTO) {
		Trainee trainee = modelmapper.map(traineeDTO, Trainee.class);
		return traineeService.updateTrainee(id, trainee);
	}

	@DeleteMapping("/trainee/{id}")
	public void deleteTrainee(@PathVariable(name = "id") Integer id) {
		traineeService.deleteTrainee(id);
	}

}
