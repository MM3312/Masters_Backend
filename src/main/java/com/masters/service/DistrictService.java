package com.masters.service;

import com.masters.dtos.DistrictDTO;
import com.masters.entity.District;
import com.masters.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    public List<DistrictDTO> getAllDistricts() {
        return districtRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public DistrictDTO saveDistrict(DistrictDTO dto) {
        District district = convertToEntity(dto);
        district.setCreatedOn(java.time.LocalDateTime.now());
        if (district.getStatus() == null) {
            district.setStatus(1);
        }
        District savedDistrict = districtRepository.save(district);
        return convertToDTO(savedDistrict);
    }

    public DistrictDTO updateDistrict(Integer id, DistrictDTO dto) {
        District existingDistrict = districtRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("District not found with id: " + id));

        existingDistrict.setDistrictName(dto.getDistrictName());
        existingDistrict.setStatus(dto.getStatus());
        existingDistrict.setUpdatedBy(dto.getUpdatedBy());
        existingDistrict.setUpdatedOn(java.time.LocalDateTime.now());

        // Treat 0 or null as null to avoid foreign key violations
        if (dto.getStateId() != null && dto.getStateId() != 0) {
            existingDistrict.setStateId(dto.getStateId());
        } else {
            existingDistrict.setStateId(null);
        }

        District updatedDistrict = districtRepository.save(existingDistrict);
        return convertToDTO(updatedDistrict);
    }

    public void deleteDistrict(Integer id, Integer updatedBy) {
        District district = districtRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("District not found with id: " + id));
        district.setStatus(0);
        district.setUpdatedBy(updatedBy);
        district.setUpdatedOn(java.time.LocalDateTime.now());
        districtRepository.save(district);
    }

    private DistrictDTO convertToDTO(District district) {
        if (district == null) {
            return null;
        }
        DistrictDTO dto = new DistrictDTO();
        dto.setDistrictId(district.getDistrictId());
        dto.setDistrictName(district.getDistrictName());
        dto.setStatus(district.getStatus());
        dto.setStateId(district.getStateId());
        dto.setCreatedBy(district.getCreatedBy());
        dto.setUpdatedBy(district.getUpdatedBy());
        return dto;
    }

    private District convertToEntity(DistrictDTO dto) {
        if (dto == null) {
            return null;
        }
        District district = new District();
        district.setDistrictId(dto.getDistrictId());
        district.setDistrictName(dto.getDistrictName());
        district.setStatus(dto.getStatus());
        district.setCreatedBy(dto.getCreatedBy());
        district.setUpdatedBy(dto.getUpdatedBy());

        // Treat 0 or null as null to avoid foreign key violations
        if (dto.getStateId() != null && dto.getStateId() != 0) {
            district.setStateId(dto.getStateId());
        } else {
            district.setStateId(null);
        }
        return district;
    }
}
