package com.masters.service;

import com.masters.entity.City;
import com.masters.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    /**
     * Saves a new city or updates an existing one.
     * 
     * @param city The city to save
     * @return The saved city
     */
    public City saveCity(City city) {
        if (city.getCityId() == null) {
            city.setCreatedOn(LocalDateTime.now());
            if (city.getStatus() == null) {
                city.setStatus(1);
            }
        } else {
            city.setUpdatedOn(LocalDateTime.now());
        }
        return cityRepository.save(city);
    }
}
