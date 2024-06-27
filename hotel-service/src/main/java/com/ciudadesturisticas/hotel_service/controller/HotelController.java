package com.ciudadesturisticas.hotel_service.controller;

import com.ciudadesturisticas.hotel_service.entity.Hotel;
import com.ciudadesturisticas.hotel_service.service.HotelService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {


    @Value("${server.port}")
    private String port;

    @Autowired
    private HotelService hotelService;

    @PostMapping("/save")
    public ResponseEntity<String> createHotel(@RequestBody Hotel hotel) {
        hotelService.save(hotel);
        return ResponseEntity.ok("Hotel successfully created!");
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.findAll();
        if (hotels.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(hotels);
        }
    }

    @GetMapping("/findByIdCity/{idCity}")
    public ResponseEntity<List<Hotel>> getHotelByIdCity(@PathVariable Long idCity) {
        System.out.println("----------estoy en : " + port);
        List<Hotel> hotels = hotelService.getHotelsByCity(idCity);
        if (hotels.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(hotels);
        }
    }


}
