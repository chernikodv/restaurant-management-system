package edu.northeastern.khoury.ds.domain.model;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Embeddable
@NoArgsConstructor
public class EmployeeScheduleId implements Serializable {

    @Serial
    private static final long serialVersionUID = 439544104573419048L;

    private Integer employeeId;
    private Integer weekday;
}
