package com.masters.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityUpdateDTO {
    private String cityCode;
    private String cityName;
    private String payrollCityCode;
    private Integer districtId;
    private Integer status;
    private Integer updatedBy;
}
