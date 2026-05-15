package com.masters.service;

import com.masters.dto.CityDTO;
import com.masters.dto.CityGetDTO;
import com.masters.dto.CityUpdateDTO;
import com.masters.entity.City;
import com.masters.entity.District;
import com.masters.repository.CityRepository;
import com.masters.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for handling City business logic.
 * Manages interactions between CityDTOs and the City database entity.
 */
@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private DistrictRepository districtRepository;

    /**
     * Retrieves all cities with an 'Active' status (status = 1).
     * Maps the results to CityGetDTO for a lightweight response.
     * 
     * @return List of active city summaries
     */
    public List<CityGetDTO> getAllCitiesSummary() {
        return cityRepository.findByStatus(1).stream()
                .map(city -> {
                    CityGetDTO dto = new CityGetDTO();
                    dto.setCityId(city.getCityId());
                    dto.setCityCode(city.getCityCode());
                    dto.setCityName(city.getCityName());
                    dto.setPayrollCityCode(city.getPayrollCityCode());
                    if (city.getDistrict() != null) {
                        dto.setDistrictId(city.getDistrict().getDistrictId());
                        dto.setDistrictName(city.getDistrict().getDistrictName());
                    }
                    return dto;
                })
                .collect(Collectors.toList());
    }

    /**
     * Saves or updates a city record.
     * If cityId is provided and exists, the record is updated.
     * If cityId is null or not found, a new record is created.
     * 
     * @param cityDTO The city data from the request
     * @return The saved city as a CityDTO
     */
    public CityDTO saveCity(CityDTO cityDTO) {
        City city;
        // Check if we are updating an existing city
        if (cityDTO.getCityId() != null && cityDTO.getCityId() > 0) {
            city = cityRepository.findById(cityDTO.getCityId()).orElse(new City());
        } else {
            // Otherwise, initialize a new city entity
            city = new City();
            city.setCreatedOn(LocalDateTime.now());
        }

        // Set default values for new cities
        if (city.getCityId() == null) {
            city.setStatus(1);
            city.setCreatedBy(cityDTO.getCreatedBy());
        }

        // Map fields from DTO to Entity
        city.setCityCode(cityDTO.getCityCode());
        city.setCityName(cityDTO.getCityName());
        city.setPayrollCityCode(cityDTO.getPayrollCityCode());

        // Handle District relationship
        if (cityDTO.getDistrictId() != null && cityDTO.getDistrictId() > 0) {
            District district = districtRepository.findById(cityDTO.getDistrictId())
                    .orElseThrow(() -> new RuntimeException("District not found with id: " + cityDTO.getDistrictId()));
            city.setDistrict(district);
        }

        // Update status if provided in the request
        if (cityDTO.getStatus() != null) {
            city.setStatus(cityDTO.getStatus());
        }

        // Save the entity to the database
        City savedCity = cityRepository.save(city);

        // Map the saved entity back to a CityDTO for the response
        CityDTO responseDto = new CityDTO();
        responseDto.setCityId(savedCity.getCityId());
        responseDto.setCityCode(savedCity.getCityCode());
        responseDto.setCityName(savedCity.getCityName());
        responseDto.setPayrollCityCode(savedCity.getPayrollCityCode());
        responseDto.setStatus(savedCity.getStatus());
        // responseDto.setCreatedOn(savedCity.getCreatedOn());

        if (savedCity.getDistrict() != null) {
            responseDto.setDistrictId(savedCity.getDistrict().getDistrictId());
        }

        return responseDto;
    }

    /**
     * Updates an existing city record.
     * 
     * @param id        The ID of the city to update
     * @param updateDTO The new data for the city (excluding createdBy)
     * @return The updated CityUpdateDTO response
     */
    public CityUpdateDTO updateCity(Integer id, CityUpdateDTO updateDTO) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found with id: " + id));

        // Map fields from UpdateDTO to Entity
        city.setCityCode(updateDTO.getCityCode());
        city.setCityName(updateDTO.getCityName());
        city.setPayrollCityCode(updateDTO.getPayrollCityCode());
        city.setUpdatedBy(updateDTO.getUpdatedBy());

        if (updateDTO.getDistrictId() != null && updateDTO.getDistrictId() > 0) {
            District district = districtRepository.findById(updateDTO.getDistrictId())
                    .orElseThrow(
                            () -> new RuntimeException("District not found with id: " + updateDTO.getDistrictId()));
            city.setDistrict(district);
        }

        if (updateDTO.getStatus() != null) {
            city.setStatus(updateDTO.getStatus());
        }

        City savedCity = cityRepository.save(city);

        // Map back to UpdateDTO for response
        CityUpdateDTO response = new CityUpdateDTO();
        response.setCityCode(savedCity.getCityCode());
        response.setCityName(savedCity.getCityName());
        response.setPayrollCityCode(savedCity.getPayrollCityCode());
        response.setStatus(savedCity.getStatus());
        response.setUpdatedBy(savedCity.getUpdatedBy());
        if (savedCity.getDistrict() != null) {
            response.setDistrictId(savedCity.getDistrict().getDistrictId());
        }

        return response;
    }

    /**
     * Deletes a city record based on ID.
     * This is implemented as a soft delete by setting status to 0.
     * 
     * @param id        The ID of the city to delete
     * @param updatedBy The ID of the user performing the deletion
     */
    public void deleteCity(Integer id, Integer updatedBy) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found with id: " + id));

        // Soft delete: set status to 0 and record who did it
        city.setStatus(0);
        city.setUpdatedBy(updatedBy);
        cityRepository.save(city);
    }
}
