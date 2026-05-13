package com.masters.repository;

import com.masters.entity.SubStream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubStreamRepository extends JpaRepository<SubStream, Integer> {
}
