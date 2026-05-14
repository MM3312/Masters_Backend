package com.masters.dtos;

import lombok.Data;

@Data
public class StateUpdateDTO {
    private String stateName;
    private String stateCode;
    private Integer isActive;
    private Integer updatedBy;
}
