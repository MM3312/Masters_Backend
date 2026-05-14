package com.masters.service;

import com.masters.dtos.StateDTO;
import com.masters.entity.State;
import com.masters.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public List<StateDTO> getAllStates() {
        return stateRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public StateDTO saveState(StateDTO dto) {
        State state = convertToEntity(dto);
        state.setCreatedOn(LocalDateTime.now());
        if (state.getIsActive() == null) {
            state.setIsActive(1);
        }
        State savedState = stateRepository.save(state);
        return convertToDTO(savedState);
    }

    public StateDTO updateState(Integer id, StateDTO dto) {
        State existingState = stateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("State not found with id: " + id));

        existingState.setStateName(dto.getStateName());
        existingState.setStateCode(dto.getStateCode());
        existingState.setIsActive(dto.getIsActive());
        existingState.setUpdatedBy(dto.getUpdatedBy());
        existingState.setUpdatedOn(LocalDateTime.now());

        State updatedState = stateRepository.save(existingState);
        return convertToDTO(updatedState);
    }

    public void deleteState(Integer id, Integer updatedBy) {
        State state = stateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("State not found with id: " + id));
        state.setIsActive(0);
        state.setUpdatedBy(updatedBy);
        state.setUpdatedOn(LocalDateTime.now());
        stateRepository.save(state);
    }

    private StateDTO convertToDTO(State state) {
        if (state == null) {
            return null;
        }
        StateDTO dto = new StateDTO();
        dto.setStateId(state.getStateId());
        dto.setStateName(state.getStateName());
        dto.setStateCode(state.getStateCode());
        dto.setIsActive(state.getIsActive());
        dto.setCreatedBy(state.getCreatedBy());
        dto.setUpdatedBy(state.getUpdatedBy());
        return dto;
    }

    private State convertToEntity(StateDTO dto) {
        if (dto == null) {
            return null;
        }
        State state = new State();
        state.setStateId(dto.getStateId());
        state.setStateName(dto.getStateName());
        state.setStateCode(dto.getStateCode());
        state.setIsActive(dto.getIsActive());
        state.setCreatedBy(dto.getCreatedBy());
        state.setUpdatedBy(dto.getUpdatedBy());
        return state;
    }
}
