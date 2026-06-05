package com.darragh.holiday_planner_api;

import com.darragh.holiday_planner_api.model.Holiday;
import com.darragh.holiday_planner_api.repository.HolidayRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HolidayPlannerApiApplicationTests {

    @Autowired
    private HolidayRepository holidayRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testCreateAndRetrieveHoliday() {
        Holiday holiday = new Holiday();
        holiday.setDestination("Ibiza");
        holiday.setStartDate(LocalDate.of(2026, 7, 1));
        holiday.setEndDate(LocalDate.of(2026, 7, 14));
        holiday.setNumberOfPeople(6);
        holiday.setBudget(3000.00);

        Holiday saved = holidayRepository.save(holiday);

        assertNotNull(saved.getId());
        assertEquals("Ibiza", saved.getDestination());
        assertEquals(6, saved.getNumberOfPeople());
        assertEquals(3000.00, saved.getBudget());
    }

    @Test
    void testDeleteHoliday() {
        Holiday holiday = new Holiday();
        holiday.setDestination("Magaluf");
        holiday.setStartDate(LocalDate.of(2026, 8, 1));
        holiday.setEndDate(LocalDate.of(2026, 8, 7));
        holiday.setNumberOfPeople(4);
        holiday.setBudget(2000.00);

        Holiday saved = holidayRepository.save(holiday);
        Long id = saved.getId();

        holidayRepository.deleteById(id);

        assertFalse(holidayRepository.findById(id).isPresent());
    }
}
