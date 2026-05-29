package com.darragh.holiday_planner_api.service;
import com.darragh.holiday_planner_api.model.Holiday;
import com.darragh.holiday_planner_api.model.Hotel;
import com.darragh.holiday_planner_api.repository.HolidayRepository;
import com.darragh.holiday_planner_api.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;
    private final HolidayRepository holidayRepository;


    public HotelService(HotelRepository hotelRepository, HolidayRepository holidayRepository) {
        this.hotelRepository = hotelRepository;
        this.holidayRepository = holidayRepository;
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    public Hotel createHotel(Hotel hotel) {
        if (hotel.getHoliday() != null && hotel.getHoliday().getId() != null) {
            Holiday fullHoliday = holidayRepository.findById(hotel.getHoliday().getId()).orElse(null);
            hotel.setHoliday(fullHoliday);
        }
        return hotelRepository.save(hotel);
    }

    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }

    public Hotel updateHotel(Long id, Hotel updatedHotel) {
        updatedHotel.setId(id);
        return hotelRepository.save(updatedHotel);
    }
}
