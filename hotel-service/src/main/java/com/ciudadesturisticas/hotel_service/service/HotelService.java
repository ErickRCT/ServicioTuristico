package com.ciudadesturisticas.hotel_service.service;


import com.ciudadesturisticas.hotel_service.entity.Hotel;

import java.util.List;

public interface HotelService {

    void save(Hotel hotel);

    List<Hotel> findAll();

    List<Hotel> getHotelsByCity(long idCity);

}
