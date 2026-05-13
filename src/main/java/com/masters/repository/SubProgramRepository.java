package com.masters.repository;

import com.masters.entity.SubProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubProgramRepository extends JpaRepository<SubProgram, Integer> {
}
