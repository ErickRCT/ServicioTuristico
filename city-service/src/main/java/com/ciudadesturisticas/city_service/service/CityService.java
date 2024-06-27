package com.ciudadesturisticas.city_service.service;

import com.ciudadesturisticas.city_service.dto.CityDto;
import com.ciudadesturisticas.city_service.entity.City;

import java.util.List;

public interface CityService {

    void save(City city);

    List<City> findAll();

    CityDto findCityByNameAndCountry(String cityName, String country);

}
