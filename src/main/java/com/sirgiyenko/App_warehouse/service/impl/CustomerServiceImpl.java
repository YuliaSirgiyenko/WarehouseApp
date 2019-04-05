package com.sirgiyenko.App_warehouse.service.impl;

import com.sirgiyenko.App_warehouse.entity.Customer;
import com.sirgiyenko.App_warehouse.repository.CustomerRepository;
import com.sirgiyenko.App_warehouse.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional
    public Customer createCustomer(String firstName, String lastName, String company, String status) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setCompany(company);
        customer.setStatus(status);
        customerRepository.create(customer);
        return customer;
    }

}
