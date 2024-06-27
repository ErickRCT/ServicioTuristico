package com.ciudadesturisticas.hotel_service.service;

import com.ciudadesturisticas.hotel_service.entity.Hotel;
import com.ciudadesturisticas.hotel_service.repository.HotelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;

    @Override
    public void save(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public List<Hotel> getHotelsByCity(long idCity) {
        return hotelRepository.findHotelByIdCity(idCity);
    }
}
