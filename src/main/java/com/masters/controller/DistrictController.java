package com.masters.controller;

import com.masters.dtos.DistrictDTO;
import com.masters.dtos.DistrictSaveDTO;
import com.masters.dtos.DistrictUpdateDTO;
import com.masters.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/districts")
@CrossOrigin("*")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllDistricts() {
        try {
            List<DistrictDTO> districts = districtService.getAllDistricts();
            return ResponseEntity.ok(districts);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveDistrict(@RequestBody DistrictSaveDTO districtSaveDTO) {
        try {
            DistrictDTO districtDTO = new DistrictDTO();
            districtDTO.setDistrictName(districtSaveDTO.getDistrictName());
            districtDTO.setStatus(districtSaveDTO.getStatus());
            districtDTO.setStateId(districtSaveDTO.getStateId());
            districtDTO.setCreatedBy(districtSaveDTO.getCreatedBy());
            
            DistrictDTO savedDistrict = districtService.saveDistrict(districtDTO);
            return ResponseEntity.ok(savedDistrict);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateDistrict(@PathVariable Integer id, @RequestBody DistrictUpdateDTO districtUpdateDTO) {
        try {
            DistrictDTO districtDTO = new DistrictDTO();
            districtDTO.setDistrictName(districtUpdateDTO.getDistrictName());
            districtDTO.setStatus(districtUpdateDTO.getStatus());
            districtDTO.setStateId(districtUpdateDTO.getStateId());
            districtDTO.setUpdatedBy(districtUpdateDTO.getUpdatedBy());
            
            DistrictDTO updatedDistrict = districtService.updateDistrict(id, districtDTO);
            return ResponseEntity.ok(updatedDistrict);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDistrict(@PathVariable Integer id, @RequestParam Integer updatedBy) {
        try {
            districtService.deleteDistrict(id, updatedBy);
            return ResponseEntity.ok("District deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }
}
