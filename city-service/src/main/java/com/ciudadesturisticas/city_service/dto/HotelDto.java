package com.ciudadesturisticas.city_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {
    private long idHotel;
    private String nombre;
    private String estrellas;
    private long idCity;
}
