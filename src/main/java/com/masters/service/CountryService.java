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

    /**
     * Updates an existing country record.
     * @param id The ID of the country to update
     * @param countryDetails The updated details
     * @return The updated country
     */
    public Country updateCountry(Integer id, Country countryDetails) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found with id: " + id));

        country.setCountryName(countryDetails.getCountryName());
        country.setUpdatedBy(countryDetails.getUpdatedBy());
        country.setCountryContNo(countryDetails.getCountryContNo());

        return countryRepository.save(country);
    }

    /**
     * Soft deletes a country by setting status to 0.
     * @param id The ID of the country to delete
     */
    /**
     * Soft deletes a country by setting status to 0.
     * @param id The ID of the country to delete
     */
    /**
     * Soft deletes a country by setting status to 0.
     * @param id The ID of the country to delete
     * @param updatedBy The ID of the user performing the deletion
     */
    public void deleteCountry(Integer id, Integer updatedBy) {
        countryRepository.softDeleteCountry(id, updatedBy);
    }
}
