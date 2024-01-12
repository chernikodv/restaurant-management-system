package edu.northeastern.khoury.ds.domain.dto;

import java.time.LocalDate;

public record AddFavoriteMenuItemResponse (String username,
                                           Integer menuItemId,
                                           LocalDate likedAt) {
}
