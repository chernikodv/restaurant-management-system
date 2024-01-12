package edu.northeastern.khoury.ds.domain.model;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Embeddable
@NoArgsConstructor
public class OnlineOrderInfoId implements Serializable {

    @Serial
    private static final long serialVersionUID = 5213427658386387430L;

    private Integer menuItemId;
    private Integer onlineOrderId;
}
