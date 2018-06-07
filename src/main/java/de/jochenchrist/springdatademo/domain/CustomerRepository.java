package de.jochenchrist.springdatademo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    List<Customer> findByEmailAddressAndNameOrderByIdDesc(String emailAddress, String name);


}
