package com.masters.repository;

import com.masters.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
    List<Country> findByStatus(Integer status);
    List<Country> findByCountryNameContainingIgnoreCase(String countryName);

    @Modifying
    @Transactional
    @Query("UPDATE Country c SET c.status = 0, c.updatedBy = :updatedBy, c.updatedOn = CURRENT_TIMESTAMP WHERE c.countryId = :id")
    void softDeleteCountry(@Param("id") Integer id, @Param("updatedBy") Integer updatedBy);
}
