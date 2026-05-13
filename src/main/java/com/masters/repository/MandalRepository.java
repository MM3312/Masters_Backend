package com.masters.repository;

import com.masters.entity.Mandal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MandalRepository extends JpaRepository<Mandal, Integer> {
    List<Mandal> findByIsActive(Integer isActive);
    List<Mandal> findByMandalNameContainingIgnoreCase(String mandalName);
}
