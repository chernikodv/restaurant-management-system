package edu.northeastern.khoury.ds.domain.dto;

import edu.northeastern.khoury.ds.domain.model.MenuItemNameQuantity;

import java.util.List;

public record OnlineOrderResponse(int orderId, PaymentResponse payment, EmployeeResponse assignedTo, List<MenuItemNameQuantity> items) {
}
