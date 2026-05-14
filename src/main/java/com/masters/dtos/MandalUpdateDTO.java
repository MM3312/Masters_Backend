package com.masters.dtos;

import lombok.Data;

@Data
public class MandalUpdateDTO {
    private String mandalName;
    private Integer districtId;
    private Integer stateId;
    private Integer isActive;
    private Integer updatedBy;
}
