package com.sirgiyenko.App_warehouse.service;

import com.sirgiyenko.App_warehouse.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer createCustomer(String firstName, String lastName, String company, String status);

}
