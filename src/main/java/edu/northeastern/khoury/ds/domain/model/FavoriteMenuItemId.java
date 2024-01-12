package edu.northeastern.khoury.ds.domain.model;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Embeddable
@NoArgsConstructor
public class FavoriteMenuItemId implements Serializable {

    @Serial
    private static final long serialVersionUID = 1824864143391594275L;

    private String username;
    private Integer menuItemId;
}
