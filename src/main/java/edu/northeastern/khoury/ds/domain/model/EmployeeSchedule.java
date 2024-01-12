package edu.northeastern.khoury.ds.domain.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

import java.time.LocalTime;

@Data
@Entity
@Table(name = "employee_schedule")
public class EmployeeSchedule {

    @EmbeddedId
    private EmployeeScheduleId id;

    @ToString.Exclude
    @MapsId(value = "employeeId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    private LocalTime shiftFrom;
    private LocalTime shiftTo;
}
