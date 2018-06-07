package de.jochenchrist.springdatademo.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository repository;

    @Autowired
    AddressRepository addressRepository;

    @Test
    public void shouldCreateAndQueryCustomer() {
        Customer customer = new Customer();
        String id = "cu123242345345";
        customer.setId(id);
        customer.setName("Mickey Mouse");
        customer.setEmailAddress("mickey@disney.com");
        Address address = new Address();
        address.setAddressId("ad123123424");
        address.setStreet("Mausstr. 12");
        address.setZipCode("12345");
        address.setCity("Entenhausen");
        customer.setAddresses(Collections.singletonList(address));

        Customer savedCustomer = repository.save(customer);

        Customer retrievedCustomer = repository.getOne(id);
        assertThat(retrievedCustomer)
                .isNotNull()
                .hasFieldOrPropertyWithValue("name", "Mickey Mouse");
    }

    @Test
    public void shouldFindByEmailAddress() {
        Customer customer = new Customer();
        String id = "cu123242345341";
        customer.setId(id);
        customer.setName("Mickey Mouse");
        customer.setEmailAddress("mickey@disney.com");
        Address address = new Address();
        address.setAddressId("ad123123424");
        address.setStreet("Mausstr. 12");
        address.setZipCode("12345");
        address.setCity("Entenhausen");
        customer.setAddresses(Collections.singletonList(address));
        Customer savedCustomer = repository.save(customer);

        List<Customer> customers = repository.findByEmailAddressAndNameOrderByIdDesc("mickey@disney.com", customer.getName());

        assertThat(customers).hasSize(1);
    }
}