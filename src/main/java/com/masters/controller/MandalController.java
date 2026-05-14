package com.masters.controller;

import com.masters.dtos.MandalDTO;
import com.masters.dtos.MandalSaveDTO;
import com.masters.dtos.MandalUpdateDTO;
import com.masters.service.MandalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mandals")
@CrossOrigin("*")
public class MandalController {

    @Autowired
    private MandalService mandalService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllMandals() {
        try {
            List<MandalDTO> mandals = mandalService.getAllMandals();
            return ResponseEntity.ok(mandals);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveMandal(@RequestBody MandalSaveDTO mandalSaveDTO) {
        try {
            MandalDTO mandalDTO = new MandalDTO();
            mandalDTO.setMandalName(mandalSaveDTO.getMandalName());
            mandalDTO.setDistrictId(mandalSaveDTO.getDistrictId());
            mandalDTO.setStateId(mandalSaveDTO.getStateId());
            mandalDTO.setIsActive(mandalSaveDTO.getIsActive());
            mandalDTO.setCreatedBy(mandalSaveDTO.getCreatedBy());
            
            MandalDTO savedMandal = mandalService.saveMandal(mandalDTO);
            return ResponseEntity.ok(savedMandal);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMandal(@PathVariable Integer id, @RequestBody MandalUpdateDTO mandalUpdateDTO) {
        try {
            MandalDTO mandalDTO = new MandalDTO();
            mandalDTO.setMandalName(mandalUpdateDTO.getMandalName());
            mandalDTO.setDistrictId(mandalUpdateDTO.getDistrictId());
            mandalDTO.setStateId(mandalUpdateDTO.getStateId());
            mandalDTO.setIsActive(mandalUpdateDTO.getIsActive());
            mandalDTO.setUpdatedBy(mandalUpdateDTO.getUpdatedBy());
            
            MandalDTO updatedMandal = mandalService.updateMandal(id, mandalDTO);
            return ResponseEntity.ok(updatedMandal);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMandal(@PathVariable Integer id, @RequestParam Integer updatedBy) {
        try {
            mandalService.deleteMandal(id, updatedBy);
            return ResponseEntity.ok("Mandal deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }
}
