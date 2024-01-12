package edu.northeastern.khoury.ds.domain.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "account")
public class Account {

    @Id
    private String username;

    private String email;
    private String password;

    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "phone_number", referencedColumnName = "phone_number")
    private Customer customer;

    @ToString.Exclude
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "account_credit_card",
            joinColumns = @JoinColumn(name = "username", referencedColumnName = "username"),
            inverseJoinColumns = @JoinColumn(name = "credit_card_id", referencedColumnName = "id")
    )
    private List<CreditCard> creditCards = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "account")
    private List<OnlineOrder> onlineOrders = new ArrayList<>();
}
