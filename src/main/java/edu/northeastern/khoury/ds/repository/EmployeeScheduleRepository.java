package edu.northeastern.khoury.ds.repository;

import edu.northeastern.khoury.ds.domain.model.EmployeeSchedule;
import edu.northeastern.khoury.ds.domain.model.EmployeeScheduleId;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalTime;
import java.util.List;

public interface EmployeeScheduleRepository extends JpaRepository<EmployeeSchedule, EmployeeScheduleId> {
    @EntityGraph(attributePaths = { "employee" })
    List<EmployeeSchedule> findById_WeekdayAndAndShiftFromIsLessThanEqualAndShiftToIsGreaterThanEqual(int weekday, LocalTime time, LocalTime sameTime);

    default List<EmployeeSchedule> findAvailable(int weekday, LocalTime time) {
        return findById_WeekdayAndAndShiftFromIsLessThanEqualAndShiftToIsGreaterThanEqual(weekday, time, time);
    }
}
