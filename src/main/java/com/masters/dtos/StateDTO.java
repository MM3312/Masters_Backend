package com.masters.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StateDTO {
    private Integer stateId;
    private String stateName;
    private String stateCode;
    private Integer isActive;
    private Integer createdBy;
    private Integer updatedBy;
}
