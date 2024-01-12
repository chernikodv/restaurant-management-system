package edu.northeastern.khoury.ds.mapper;

import edu.northeastern.khoury.ds.domain.dto.EmployeeResponse;
import edu.northeastern.khoury.ds.domain.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeResponse mapToResponse(Employee employee) {
        return new EmployeeResponse(employee.getFirstName(), employee.getLastName());
    }
}
