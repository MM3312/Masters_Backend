package com.masters.dtos;

import lombok.Data;

@Data
public class StateSaveDTO {
    private String stateName;
    private String stateCode;
    private Integer isActive;
    private Integer createdBy;
}
