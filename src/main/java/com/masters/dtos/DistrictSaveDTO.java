package com.masters.dtos;

import lombok.Data;

@Data
public class DistrictSaveDTO {
    private String districtName;
    private Integer status;
    private Integer stateId;
    private Integer createdBy;
}
