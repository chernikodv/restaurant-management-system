package edu.northeastern.khoury.ds.domain.dto;

import java.math.BigDecimal;

public record EmployeeSalaryResponse (BigDecimal base, BigDecimal tips, BigDecimal total) {
}
