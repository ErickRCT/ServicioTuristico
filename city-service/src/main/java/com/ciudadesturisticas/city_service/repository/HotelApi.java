package com.ciudadesturisticas.city_service.repository;

import com.ciudadesturisticas.city_service.dto.HotelDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "hotel-service")
public interface HotelApi {

    @GetMapping("/hotel/findByIdCity/{idCity}")
    List<HotelDto> getHotelByIdCity(@PathVariable Long idCity);

}
