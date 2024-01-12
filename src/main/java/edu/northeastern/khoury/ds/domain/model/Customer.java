package edu.northeastern.khoury.ds.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "phone_number")
    private String phoneNumber;

    private String lastName;
    private String firstName;
}
