package edu.northeastern.khoury.ds.domain.dto;

import java.math.BigDecimal;
import java.util.List;

public record CreateOnlineOrderRequest(BigDecimal tip,
                                       Integer creditCardId,
                                       List<MenuItemQuantity> onlineOrderInfo) {
}
