package com.ciudadesturisticas.city_service.controller;

import com.ciudadesturisticas.city_service.dto.CityDto;
import com.ciudadesturisticas.city_service.entity.City;
import com.ciudadesturisticas.city_service.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
@AllArgsConstructor
public class CityController {

    private CityService cityService;

    @PostMapping("/save")
    public ResponseEntity<String> createCity(@RequestBody City city) {
        cityService.save(city);
        return ResponseEntity.ok("City successfully created!");
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<City>> findAll() {
        List<City> cities = cityService.findAll();
        if (cities.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(cities);
        }
    }

    @GetMapping("/findHotelsByCity/{nameCity}/{nameCountry}")
    public CityDto findHotelsByCity(@PathVariable String nameCity, @PathVariable String nameCountry) {
        return cityService.findCityByNameAndCountry(nameCity, nameCountry);
    }


}
