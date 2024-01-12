package edu.northeastern.khoury.ds.domain.dto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum DeleteRequestMessage {

    DELETE_CREDIT_CARD("Credit card has been deleted!"),
    DELETE_FAVORITE_MENU_ITEM("Favorite menu item has been deleted!");

    private final String message;

    @Override
    public String toString() {
        return message;
    }
}
