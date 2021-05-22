package org.amalitech.traineesservice.service;

import java.util.List;

import org.amalitech.traineesservice.entity.Batch;
import org.amalitech.traineesservice.errors.exceptions.NotFoundException;
import org.amalitech.traineesservice.repository.BatchRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatchService {

	@Autowired
	private BatchRepository batchRepository;

	private String errorMessage = "Batch not Found";

	public List<Batch> getBatches() {
		return (List<Batch>) batchRepository.findAll();
	}

	public Batch createBatch(Batch batch) {
		return batchRepository.save(batch);
	}

	public Batch updateBatch(Integer id, Batch batch) {
		Batch batchFound = batchRepository.findById(id).orElseThrow(() -> new NotFoundException(errorMessage));
		BeanUtils.copyProperties(batch, batchFound);
		return batchRepository.save(batchFound);
	}

	public void deleteBatch(Integer id) {
		batchRepository.deleteById(id);
	}

	public Batch getBatchById(Integer id) {
		return batchRepository.findById(id).orElseThrow(() -> new NotFoundException(errorMessage));
	}
}
