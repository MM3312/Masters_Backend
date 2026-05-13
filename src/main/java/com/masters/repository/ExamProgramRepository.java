package com.masters.repository;

import com.masters.entity.ExamProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamProgramRepository extends JpaRepository<ExamProgram, Integer> {
}
