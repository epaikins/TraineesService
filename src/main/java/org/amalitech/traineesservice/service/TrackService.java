package org.amalitech.traineesservice.service;

import java.util.List;

import org.amalitech.traineesservice.entity.Track;
import org.amalitech.traineesservice.repository.TrackRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackService {

	@Autowired
	private TrackRepository trackRepository;
	
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
}
