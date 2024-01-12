package edu.northeastern.khoury.ds.controller;

import edu.northeastern.khoury.ds.domain.dto.EmployeeSalaryResponse;
import edu.northeastern.khoury.ds.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping(path = "/{id}/monthly-salary")
    public EmployeeSalaryResponse findMonthlySalary(@PathVariable Integer id) {
        return employeeService.findMonthlySalary(id);
    }
}
