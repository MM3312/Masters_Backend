package com.masters.repository;

import com.masters.entity.CmpsOrientationFeeHeadDetl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CmpsOrientationFeeHeadDetlRepository extends JpaRepository<CmpsOrientationFeeHeadDetl, Integer> {
}
