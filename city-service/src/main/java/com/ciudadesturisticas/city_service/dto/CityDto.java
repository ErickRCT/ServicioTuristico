package com.ciudadesturisticas.city_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {
    private long idCity;
    private String nameCity;
    private String nameContinent;
    private String nameCountry;
    private String nameState;
    private List<HotelDto> hotels;
}
