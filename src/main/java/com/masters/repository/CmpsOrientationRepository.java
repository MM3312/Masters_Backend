package com.masters.repository;

import com.masters.entity.CmpsOrientation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CmpsOrientationRepository extends JpaRepository<CmpsOrientation, Integer> {
}
