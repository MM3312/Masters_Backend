package com.masters.repository;

import com.masters.entity.TrackType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackTypeRepository extends JpaRepository<TrackType, Integer> {
}
