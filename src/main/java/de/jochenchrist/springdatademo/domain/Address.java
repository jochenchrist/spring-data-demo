package de.jochenchrist.springdatademo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Address {

    @Id
    String addressId;

    @ManyToOne
    Customer customer;

    String street;
    String zipCode;
    String city;

}
