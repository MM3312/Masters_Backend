package com.masters.service;

import com.masters.dtos.MandalDTO;
import com.masters.entity.District;
import com.masters.entity.Mandal;
import com.masters.entity.State;
import com.masters.repository.DistrictRepository;
import com.masters.repository.MandalRepository;
import com.masters.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MandalService {

    @Autowired
    private MandalRepository mandalRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private StateRepository stateRepository;

    /**
     * Retrieves all mandals and converts them to DTOs.
     * 
     * @return List of MandalDTO
     */
    public List<MandalDTO> getAllMandals() {
        return mandalRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Saves a new mandal.
     */
    public MandalDTO saveMandal(MandalDTO dto) {
        Mandal mandal = convertToEntity(dto);
        mandal.setCreatedOn(LocalDateTime.now());
        if (mandal.getIsActive() == null) {
            mandal.setIsActive(1);
        }
        Mandal savedMandal = mandalRepository.save(mandal);
        return convertToDTO(savedMandal);
    }

    /**
     * Updates an existing mandal.
     */
    public MandalDTO updateMandal(Integer id, MandalDTO dto) {
        Mandal existingMandal = mandalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mandal not found with id: " + id));

        existingMandal.setMandalName(dto.getMandalName());
        existingMandal.setIsActive(dto.getIsActive());
        existingMandal.setUpdatedBy(dto.getUpdatedBy());
        existingMandal.setUpdatedOn(LocalDateTime.now());

        if (dto.getDistrictId() != null) {
            District district = districtRepository.findById(dto.getDistrictId())
                    .orElseThrow(() -> new RuntimeException("District not found with id: " + dto.getDistrictId()));
            existingMandal.setDistrict(district);
        }

        if (dto.getStateId() != null) {
            State state = stateRepository.findById(dto.getStateId())
                    .orElseThrow(() -> new RuntimeException("State not found with id: " + dto.getStateId()));
            existingMandal.setState(state);
        }

        Mandal updatedMandal = mandalRepository.save(existingMandal);
        return convertToDTO(updatedMandal);
    }

    /**
     * Soft deletes a mandal.
     */
    public void deleteMandal(Integer id, Integer updatedBy) {
        Mandal mandal = mandalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mandal not found with id: " + id));
        mandal.setIsActive(0);
        mandal.setUpdatedBy(updatedBy);
        mandal.setUpdatedOn(LocalDateTime.now());
        mandalRepository.save(mandal);
    }

    private MandalDTO convertToDTO(Mandal mandal) {
        if (mandal == null) {
            return null;
        }
        MandalDTO dto = new MandalDTO();
        dto.setMandalId(mandal.getMandalId());
        dto.setMandalName(mandal.getMandalName());
        dto.setDistrictId(mandal.getDistrict() != null ? mandal.getDistrict().getDistrictId() : null);
        dto.setStateId(mandal.getState() != null ? mandal.getState().getStateId() : null);
        dto.setIsActive(mandal.getIsActive());
        dto.setCreatedBy(mandal.getCreatedBy());
        dto.setUpdatedBy(mandal.getUpdatedBy());
        return dto;
    }

    private Mandal convertToEntity(MandalDTO dto) {
        if (dto == null) {
            return null;
        }
        Mandal mandal = new Mandal();
        mandal.setMandalId(dto.getMandalId());
        mandal.setMandalName(dto.getMandalName());
        mandal.setCreatedBy(dto.getCreatedBy());
        mandal.setUpdatedBy(dto.getUpdatedBy());

        if (dto.getDistrictId() != null) {
            District district = districtRepository.findById(dto.getDistrictId())
                    .orElseThrow(() -> new RuntimeException("District not found with id: " + dto.getDistrictId()));
            mandal.setDistrict(district);
        }

        if (dto.getStateId() != null) {
            State state = stateRepository.findById(dto.getStateId())
                    .orElseThrow(() -> new RuntimeException("State not found with id: " + dto.getStateId()));
            mandal.setState(state);
        }

        mandal.setIsActive(dto.getIsActive());
        return mandal;
    }
}
