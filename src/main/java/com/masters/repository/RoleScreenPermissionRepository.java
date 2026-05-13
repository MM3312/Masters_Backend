package com.masters.repository;

import com.masters.entity.RoleScreenPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleScreenPermissionRepository extends JpaRepository<RoleScreenPermission, Integer> {
}
