package com.ciudadesturisticas.city_service.repository;

import com.ciudadesturisticas.city_service.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query("SELECT c FROM City c WHERE c.nameCity=:nameCity AND c.nameCountry=:nameCountry")
    City findByNameAndCountry(@Param("nameCity") String nameCity, @Param("nameCountry") String nameCountry);

}
