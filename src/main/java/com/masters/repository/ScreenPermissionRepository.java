package com.masters.repository;

import com.masters.entity.ScreenPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenPermissionRepository extends JpaRepository<ScreenPermission, Integer> {
}
