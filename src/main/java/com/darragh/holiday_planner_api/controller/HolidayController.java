package com.darragh.holiday_planner_api.controller;

import com.darragh.holiday_planner_api.model.Holiday;
import com.darragh.holiday_planner_api.service.HolidayService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/holidays")
public class HolidayController {

    private final HolidayService holidayService;

    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @GetMapping
    public List<Holiday> getAllHolidays() {
        return holidayService.getAllHolidays();
    }

    @GetMapping("/{id}")
    public Holiday getHolidayById(@PathVariable Long id) {
        return holidayService.getHolidayById(id);
    }

    @PostMapping
    public Holiday createHoliday(@RequestBody Holiday holiday) {
        return holidayService.createHoliday(holiday);
    }

    @PutMapping("/{id}")
    public Holiday updateHoliday(@PathVariable Long id, @RequestBody Holiday holiday) {
        return holidayService.updateHoliday(id, holiday);
    }

    @DeleteMapping("/{id}")
    public void deleteHoliday(@PathVariable Long id) {
        holidayService.deleteHoliday(id);
    }
}
