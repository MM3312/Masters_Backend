package com.masters.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MandalDTO {
    private Integer mandalId;
    private String mandalName;
    private Integer districtId;
    private Integer stateId;
    private Integer isActive;
    private Integer createdBy;
    private Integer updatedBy;
}
