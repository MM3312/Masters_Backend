package com.masters.repository;

import com.masters.entity.PinCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PinCodeRepository extends JpaRepository<PinCode, Integer> {
    List<PinCode> findByPinCode(Integer pinCode);
    List<PinCode> findByIsActive(Integer isActive);
}
