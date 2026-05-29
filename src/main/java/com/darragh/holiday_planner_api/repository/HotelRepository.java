package com.darragh.holiday_planner_api.repository;
import com.darragh.holiday_planner_api.model.Holiday;
import com.darragh.holiday_planner_api.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface HotelRepository extends JpaRepository<Hotel,Long> {
}
