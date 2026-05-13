package com.masters.controller;

import com.masters.entity.Country;
import com.masters.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@CrossOrigin("*")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/active")
    public List<Country> getActiveCountries() {
        return countryService.getActiveCountries();
    }

    @PostMapping("/save")
    public ResponseEntity<Country> saveCountry(@RequestBody Country country) {
        Country savedCountry = countryService.saveCountry(country);
        return ResponseEntity.ok(savedCountry);
    }
}
