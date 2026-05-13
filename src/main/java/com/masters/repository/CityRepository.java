package com.masters.repository;

import com.masters.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findByStatus(Integer status);
    List<City> findByCityNameContainingIgnoreCase(String cityName);
}
