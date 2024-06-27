package com.ciudadesturisticas.hotel_service.repository;

import com.ciudadesturisticas.hotel_service.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @Query("SELECT h FROM Hotel h WHERE h.idCity = :idCity")
    List<Hotel> findHotelByIdCity(@Param("idCity") long idCity);
}
