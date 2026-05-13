package com.masters.service;

import com.masters.entity.Country;
import com.masters.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    /**
     * Retrieves all countries with active status (status = 1).
     * 
     * @return List of active countries
     */
    public List<Country> getActiveCountries() {
        return countryRepository.findByStatus(1);
    }

    /**
     * Saves a new country or updates an existing one.
     * @param country The country to save
     * @return The saved country
     */
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }
}
