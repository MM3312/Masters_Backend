package com.masters.repository;

import com.masters.entity.OrientationStreamProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrientationStreamProgramRepository extends JpaRepository<OrientationStreamProgram, Integer> {
}
