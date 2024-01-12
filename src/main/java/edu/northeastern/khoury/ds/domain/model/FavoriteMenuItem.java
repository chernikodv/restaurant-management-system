package edu.northeastern.khoury.ds.domain.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "favorite_menu_item")
public class FavoriteMenuItem {

    @EmbeddedId
    private FavoriteMenuItemId id;

    @ToString.Exclude
    @MapsId(value = "username")
    @JoinColumn(name = "username")
    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    @ToString.Exclude
    @MapsId(value = "menuItemId")
    @ManyToOne(fetch = FetchType.LAZY)
    private MenuItem menuItem;

    private LocalDateTime likedAt;
}
