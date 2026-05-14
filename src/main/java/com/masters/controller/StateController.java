package com.masters.controller;

import com.masters.dtos.StateDTO;
import com.masters.dtos.StateSaveDTO;
import com.masters.dtos.StateUpdateDTO;
import com.masters.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/states")
@CrossOrigin("*")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllStates() {
        try {
            List<StateDTO> states = stateService.getAllStates();
            return ResponseEntity.ok(states);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveState(@RequestBody StateSaveDTO stateSaveDTO) {
        try {
            StateDTO stateDTO = new StateDTO();
            stateDTO.setStateName(stateSaveDTO.getStateName());
            stateDTO.setStateCode(stateSaveDTO.getStateCode());
            stateDTO.setIsActive(stateSaveDTO.getIsActive());
            stateDTO.setCreatedBy(stateSaveDTO.getCreatedBy());
            
            StateDTO savedState = stateService.saveState(stateDTO);
            return ResponseEntity.ok(savedState);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateState(@PathVariable Integer id, @RequestBody StateUpdateDTO stateUpdateDTO) {
        try {
            StateDTO stateDTO = new StateDTO();
            stateDTO.setStateName(stateUpdateDTO.getStateName());
            stateDTO.setStateCode(stateUpdateDTO.getStateCode());
            stateDTO.setIsActive(stateUpdateDTO.getIsActive());
            stateDTO.setUpdatedBy(stateUpdateDTO.getUpdatedBy());
            
            StateDTO updatedState = stateService.updateState(id, stateDTO);
            return ResponseEntity.ok(updatedState);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteState(@PathVariable Integer id, @RequestParam Integer updatedBy) {
        try {
            stateService.deleteState(id, updatedBy);
            return ResponseEntity.ok("State deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }
}
