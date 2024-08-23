package com.oriontek.backend_demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oriontek.backend_demo.model.ApiResponse;
import com.oriontek.backend_demo.model.Customer;
import com.oriontek.backend_demo.service.CustomerService;
import com.oriontek.backend_demo.utils.IDGenerator;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Endpoint to get the list of customers
    @GetMapping("/getAll")
    public ApiResponse<List<Customer>> getAllCustomers(HttpServletResponse httpResponse) {

        ApiResponse<List<Customer>> response = new ApiResponse<List<Customer>>(
            customerService.getAllCustomers(),
            httpResponse.getStatus()
        );

        String message = response.getData().isEmpty() ? "There are no customers registered." : "";

        response.setMessage(message);

        return response;
    }

    // Endpoint to get a customer by id
    @GetMapping("/getByID")
    public ApiResponse<Optional<Customer>> getCustomer(@RequestParam long id, HttpServletResponse httpResponse) {

        ApiResponse<Optional<Customer>> response = new ApiResponse<Optional<Customer>>(
            customerService.getCustomerById(id),
            httpResponse.getStatus()
        );

        String message = response.getData().isPresent() ? "" : "Customer not found.";

        response.setMessage(message);

        return response;
    }

    // Endpoint to create a new customer
    @PostMapping("/create")
    public ApiResponse<Customer> createCustomer(@RequestBody Customer customer, HttpServletResponse httpResponse) {

        customer.setID(IDGenerator.generate());

        ApiResponse<Customer> response = new ApiResponse<Customer>(
            customerService.addCustomer(customer),
            httpResponse.getStatus()
        );

        response.setMessage("Customer added succesfully.");

        return response;
    }

    // Endpoint to delete an existing customer
    @DeleteMapping("/delete")
    public ApiResponse<Boolean> deleteCustomer(@RequestParam  long id, HttpServletResponse httpResponse) {

        Boolean userDeleted = customerService.deleteCustomer(id);

        ApiResponse<Boolean> response = new ApiResponse<Boolean>(
            userDeleted,
            httpResponse.getStatus()
        );

        String message = userDeleted ? "Customer has been deleted." : "Customer could not be found to be deleted, verify the id is valid.";

        response.setMessage(message);

        return response;
    }
    
}
