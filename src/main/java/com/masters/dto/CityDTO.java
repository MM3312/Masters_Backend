package com.masters.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {
    private Integer cityId;
    private String cityCode;
    private String cityName;
    private String payrollCityCode;
    private Integer districtId;
    private Integer status;
    private Integer createdBy;
    private LocalDateTime createdOn;
}
