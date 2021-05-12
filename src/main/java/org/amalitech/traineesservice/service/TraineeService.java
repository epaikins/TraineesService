package org.amalitech.traineesservice.service;

import java.util.List;

import org.amalitech.traineesservice.entity.Trainee;
import org.amalitech.traineesservice.repository.TraineeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraineeService {
	
	@Autowired
	private TraineeRepository traineeRepository;
	
	
	public List<Trainee> getTrainees(){
		return traineeRepository.findAll();
	}
	
	public Trainee createTrainee(Trainee trainee) {
		return traineeRepository.save(trainee);
	}
	
	public Trainee updateTrainee(Integer id, Trainee trainee) {
		Trainee traineeFound = traineeRepository.findById(id).orElseThrow();
		trainee.setId(id);
		BeanUtils.copyProperties(trainee, traineeFound);
		
		return traineeRepository.save(traineeFound);
	
	}
	
	public void deleteTrainee(Integer id) {
		traineeRepository.deleteById(id);
	}

	public Trainee getTrainee(Integer id) {
		return traineeRepository.findById(id).get();
	}

	public Trainee getTraineeById(int id) {
		return traineeRepository.findById(id).get();
	}
	
}
