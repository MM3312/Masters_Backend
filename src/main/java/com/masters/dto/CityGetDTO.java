package com.masters.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityGetDTO {
    private Integer cityId;
    private String cityCode;
    private String cityName;
    private Integer districtId;
    private String districtName;
    private String payrollCityCode;
}
