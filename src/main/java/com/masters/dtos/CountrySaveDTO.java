package com.masters.dtos;

import lombok.Data;

@Data
public class CountrySaveDTO {
    private String countryName;
    private String countryContNo;
    private Integer createdBy;
}
