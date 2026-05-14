package com.masters.dtos;

import lombok.Data;

@Data
public class DistrictUpdateDTO {
    private String districtName;
    private Integer status;
    private Integer stateId;
    private Integer updatedBy;
}
