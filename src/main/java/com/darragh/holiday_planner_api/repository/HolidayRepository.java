package com.darragh.holiday_planner_api.repository;
import com.darragh.holiday_planner_api.model.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository


public interface HolidayRepository extends JpaRepository<Holiday, Long> {

}


