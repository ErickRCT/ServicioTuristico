package com.ciudadesturisticas.city_service.service;

import com.ciudadesturisticas.city_service.dto.CityDto;
import com.ciudadesturisticas.city_service.dto.HotelDto;
import com.ciudadesturisticas.city_service.entity.City;
import com.ciudadesturisticas.city_service.repository.CityRepository;
import com.ciudadesturisticas.city_service.repository.HotelApi;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;

    private HotelApi hotelApi;

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    @CircuitBreaker(name = "hotel-service" , fallbackMethod = "fallbackFindCityByNameAndCountry")
    @Retry(name = "hotel-service")
    public CityDto findCityByNameAndCountry(String cityName, String country) {
        City city = cityRepository.findByNameAndCountry(cityName, country);
        List<HotelDto> hotelDtos = hotelApi.getHotelByIdCity(city.getIdCity());
        CityDto cityDto = new CityDto(city.getIdCity(), city.getNameCity(),city.getNameContinent(),
                city.getNameCountry(),city.getNameState(),hotelDtos);
        //metodo para simular un error y probar circuit bracker
        //createException();
        return cityDto;
    }

    public CityDto fallbackFindCityByNameAndCountry(Throwable throwable) {
        return new CityDto(9999L,"error","error","error","error",null);
    }

    public void createException(){
        throw new IllegalArgumentException("Prueba circuit bracker");
    }
}
