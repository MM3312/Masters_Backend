package com.masters.repository;

import com.masters.entity.SctOrientation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SctOrientationRepository extends JpaRepository<SctOrientation, Integer> {
}
