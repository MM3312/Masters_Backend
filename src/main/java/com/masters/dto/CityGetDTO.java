package com.masters.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityGetDTO {
    private String cityCode;
    private String cityName;
    private Integer districtId;
    private String payrollCityCode;
}
