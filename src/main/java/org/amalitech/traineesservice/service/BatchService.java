package org.amalitech.traineesservice.service;

import java.util.List;

import org.amalitech.traineesservice.entity.Batch;
import org.amalitech.traineesservice.repository.BatchRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatchService {
	
	@Autowired
	private BatchRepository batchRepository;
	
	public List<Batch> getBatches(){
		return (List<Batch>) batchRepository.findAll();
	}
	
	public Batch createBatch(Batch batch) {
		return batchRepository.save(batch);
	}
	
	public Batch updateBatch(Integer id, Batch batch) {
		Batch batchFound = batchRepository.findById(id).orElseThrow();
		
		BeanUtils.copyProperties(batch, batchFound);

		return batchRepository.save(batchFound);
	}
	
	public void deleteBatch(Integer id) {
		batchRepository.deleteById(id);
	}
}
