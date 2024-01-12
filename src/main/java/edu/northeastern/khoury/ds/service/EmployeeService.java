package edu.northeastern.khoury.ds.service;

import edu.northeastern.khoury.ds.domain.dto.EmployeeSalaryResponse;
import edu.northeastern.khoury.ds.exception.ResourceNotFoundException;
import edu.northeastern.khoury.ds.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeSalaryResponse findMonthlySalary(Integer id) {
        final BigDecimal base = BigDecimal.valueOf(employeeRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new)
                .getSalary()).divide(BigDecimal.valueOf(12), RoundingMode.HALF_DOWN).setScale(2, RoundingMode.HALF_DOWN);
        BigDecimal tips = employeeRepository.findTipsForLast30Days(id);
        if (tips == null) {
            tips = BigDecimal.valueOf(0);
        }
        final BigDecimal total = base.add(tips);
        return new EmployeeSalaryResponse(base, tips, total);
    }
}
