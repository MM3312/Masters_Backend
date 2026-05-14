package com.masters.dtos;

import lombok.Data;

@Data
public class CountryUpdateDTO {
    private String countryName;
    private String countryContNo;
    private Integer updatedBy;
}
