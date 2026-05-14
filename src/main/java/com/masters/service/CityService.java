package com.masters.service;

import com.masters.dto.CityDTO;
import com.masters.entity.City;
import com.masters.entity.District;
import com.masters.repository.CityRepository;
import com.masters.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private DistrictRepository districtRepository;

    public CityDTO saveCity(CityDTO cityDTO) {
        City city;
        if (cityDTO.getCityId() != null && cityDTO.getCityId() > 0) {
            city = cityRepository.findById(cityDTO.getCityId()).orElse(new City());
        } else {
            city = new City();
            city.setCreatedOn(LocalDateTime.now());
            city.setStatus(1);
        }

        city.setCityCode(cityDTO.getCityCode());
        city.setCityName(cityDTO.getCityName());
        city.setPayrollCityCode(cityDTO.getPayrollCityCode());
        city.setCreatedBy(cityDTO.getCreatedBy());

        if (cityDTO.getDistrictId() != null && cityDTO.getDistrictId() > 0) {
            District district = districtRepository.findById(cityDTO.getDistrictId())
                    .orElseThrow(() -> new RuntimeException("District not found with id: " + cityDTO.getDistrictId()));
            city.setDistrict(district);
        }

        if (cityDTO.getStatus() != null) {
            city.setStatus(cityDTO.getStatus());
        }

        City savedCity = cityRepository.save(city);

        // Map back to DTO
        CityDTO responseDto = new CityDTO();
        responseDto.setCityId(savedCity.getCityId());
        responseDto.setCityCode(savedCity.getCityCode());
        responseDto.setCityName(savedCity.getCityName());
        responseDto.setPayrollCityCode(savedCity.getPayrollCityCode());
        responseDto.setStatus(savedCity.getStatus());
        responseDto.setCreatedBy(savedCity.getCreatedBy());
        responseDto.setCreatedOn(savedCity.getCreatedOn());
        if (savedCity.getDistrict() != null) {
            responseDto.setDistrictId(savedCity.getDistrict().getDistrictId());
        }

        return responseDto;
    }
}
