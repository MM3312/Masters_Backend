package com.masters.repository;

import com.masters.entity.OrientationBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrientationBatchRepository extends JpaRepository<OrientationBatch, Integer> {
}
