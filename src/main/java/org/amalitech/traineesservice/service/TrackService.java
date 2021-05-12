package org.amalitech.traineesservice.service;

import java.util.List;

import org.amalitech.traineesservice.entity.Track;
import org.amalitech.traineesservice.entity.Trainee;
import org.amalitech.traineesservice.entity.TraineeTrack;
import org.amalitech.traineesservice.repository.TrackRepository;
import org.amalitech.traineesservice.repository.TraineeRepository;
import org.amalitech.traineesservice.repository.TraineeTrackRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackService {

	@Autowired
	private TrackRepository trackRepository;
	
	@Autowired
	private TraineeRepository traineeRepository;
	
	@Autowired
	private TraineeTrackRepository traineeTrackRepository;
	
	public List<Track> getTracks(){
		return (List<Track>) trackRepository.findAll();
	}
	
	public Track createTrack(Track track) {
		return trackRepository.save(track);
	}
	
	public Track updateTrack(Integer id, Track track) {
		Track trackFound = trackRepository.findById(id).orElseThrow();
		
		BeanUtils.copyProperties(track, trackFound);

		return trackRepository.save(trackFound);
	}
	
	public void deleteTrack(Integer id) {
		trackRepository.deleteById(id);
	}
	
	
	public Track getTrack(Integer id) {
		return trackRepository.findById(id).get();
	}
	
	public void enrollTraineeToTrack(Integer trackId, Integer traineeId) {
		System.out.println(trackId);
		Track track = trackRepository.findById(trackId).get();
		
		System.out.println(trackId);
		System.out.println(track);
		Trainee trainee = traineeRepository.findById(traineeId).get();
		
		TraineeTrack traineeTrack = new TraineeTrack(trainee, track);
		
		traineeTrackRepository.save(traineeTrack);
		
//		trainee.getTraineeTracks().add(traineeTrack);
	
	}
}
