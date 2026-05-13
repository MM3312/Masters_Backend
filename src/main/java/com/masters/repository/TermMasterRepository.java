package com.masters.repository;

import com.masters.entity.TermMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TermMasterRepository extends JpaRepository<TermMaster, Integer> {
}
