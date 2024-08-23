package com.oriontek.backend_demo.service;

import com.oriontek.backend_demo.model.Customer;
import com.oriontek.backend_demo.model.Email;
import com.oriontek.backend_demo.utils.IDGenerator;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private List<Customer> customers = new ArrayList<>();

    public CustomerService () {
        // Dummy data or 'DB' for testing
        customers.addAll(
            Arrays.asList(
                new Customer(IDGenerator.generate(), "John", "Doe", "Example Corp", Arrays.asList(new Email(1L, "john.doe@example.com"), new Email(2L, "john.doe2@example.com"), new Email(3L, "john.doe3@example.com"))), 
                new Customer(IDGenerator.generate(), "Jane", "Smith", "Smith LLC", Arrays.asList(new Email(4L, "john.doe@example.com"), new Email(5L, "john.doe2@example.com"))), 
                new Customer(IDGenerator.generate(), "Alice", "Johnson", "Tech Solutions", Arrays.asList(new Email(6L, "john.doe@example.com")))
            )
        );
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Optional<Customer> getCustomerById(long id) {
        return customers.stream().filter(c -> c.getID() == id).findFirst();
    }

    public Customer addCustomer(Customer customer) {
        customers.add(customer);
        return customer;
    }

    public boolean deleteCustomer(long id) {
        return customers.removeIf(c -> c.getID() == id);
    }
}
