package org.amalitech.traineesservice.api;

import java.util.List;

import org.amalitech.traineesservice.dto.TraineeDTO;
import org.amalitech.traineesservice.entity.Trainee;
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
	private ModelMapper modelmapper;
	
	@GetMapping("/trainees")
	public List<Trainee> getTrainees(){
		return traineeService.getTrainees();
	}
	
	@PostMapping("/trainees")
	public Trainee createTrainee(@RequestBody TraineeDTO traineeDTO) {
		System.out.println(traineeDTO);
		Trainee trainee = modelmapper.map(traineeDTO, Trainee.class);
		System.out.println(trainee);
		return traineeService.createTrainee(trainee);
	}
	
	@PutMapping("/trainee/{id}")
	public Trainee updateTrainee(@PathVariable(name="id") Integer id, @RequestBody TraineeDTO traineeDTO) {
		Trainee trainee = modelmapper.map(traineeDTO, Trainee.class);
		
		return traineeService.updateTrainee(id, trainee);
	}
	
	@DeleteMapping("/trainee/{id}")
	public void deleteTrainee(@PathVariable(name="id") Integer id) {
		traineeService.deleteTrainee(id);
	}
	
	
	
}
