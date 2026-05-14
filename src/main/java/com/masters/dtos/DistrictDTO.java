package com.masters.dtos;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
public class DistrictDTO {
    @JsonIgnore
    private Integer districtId;
    private String districtName;
    private Integer status;
    private Integer stateId;
    private Integer createdBy;
    private Integer updatedBy;
}
