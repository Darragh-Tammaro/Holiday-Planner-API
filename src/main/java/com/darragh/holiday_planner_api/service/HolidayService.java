package com.darragh.holiday_planner_api.service;
import com.darragh.holiday_planner_api.model.Holiday;
import com.darragh.holiday_planner_api.repository.HolidayRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service

public class HolidayService {
    private final HolidayRepository holidayRepository;
    public HolidayService(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    public List<Holiday> getAllHolidays(){
        return holidayRepository.findAll();
    }

    public Holiday getHolidayById(Long id){
        return holidayRepository.findById(id).orElse(null);
    }

    public Holiday createHoliday(Holiday holiday) {
        return holidayRepository.save(holiday);
    }

    public void deleteHoliday(Long id){
        holidayRepository.deleteById(id);
    }

    public Holiday updateHoliday(Long id, Holiday updatedHoliday){
        updatedHoliday.setId(id);
        return holidayRepository.save(updatedHoliday);
    }
}
