package org.amalitech.traineesservice.repository;

import org.amalitech.traineesservice.entity.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Integer>{
}
