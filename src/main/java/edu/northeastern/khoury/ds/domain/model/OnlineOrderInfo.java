package edu.northeastern.khoury.ds.domain.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "online_order_info")
public class OnlineOrderInfo {

    @EmbeddedId
    private OnlineOrderInfoId id;

    @ToString.Exclude
    @MapsId(value = "onlineOrderId")
    @ManyToOne(fetch = FetchType.LAZY)
    private OnlineOrder onlineOrder;

    @ToString.Exclude
    @MapsId(value = "menuItemId")
    @ManyToOne(fetch = FetchType.LAZY)
    private MenuItem menuItem;

    private Integer quantity;
}
