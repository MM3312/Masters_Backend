package com.masters.repository;

import com.masters.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
    List<Country> findByStatus(Integer status);
    List<Country> findByCountryNameContainingIgnoreCase(String countryName);
}
