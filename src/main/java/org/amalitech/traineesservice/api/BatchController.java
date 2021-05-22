package org.amalitech.traineesservice.api;

import java.util.List;

import org.amalitech.traineesservice.dto.BatchDTO;
import org.amalitech.traineesservice.entity.Batch;
import org.amalitech.traineesservice.service.BatchService;
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
public class BatchController {

	@Autowired
	private BatchService batchService;

	@Autowired
	private ModelMapper modelmapper;

	@GetMapping("/batches")
	public List<Batch> getBatches() {
		return batchService.getBatches();
	}

	@GetMapping("/batch/{id}")
	public Batch getBatchById(@PathVariable(name = "id") Integer id) {
		return batchService.getBatchById(id);
	}

	@PostMapping("/batch")
	public Batch createBatch(@RequestBody BatchDTO batchDTO) {
		Batch batch = modelmapper.map(batchDTO, Batch.class);

		return batchService.createBatch(batch);
	}

	@PutMapping("/batch/{id}")
	public Batch updateBatch(@PathVariable(name = "id") Integer id, @RequestBody BatchDTO batchDTO) {
		Batch batch = modelmapper.map(batchDTO, Batch.class);
		batch.setId(id);

		return batchService.updateBatch(id, batch);
	}

	@DeleteMapping("/batch/{id}")
	public void deleteBatch(@PathVariable(name = "id") Integer id) {
		batchService.deleteBatch(id);
	}
}
