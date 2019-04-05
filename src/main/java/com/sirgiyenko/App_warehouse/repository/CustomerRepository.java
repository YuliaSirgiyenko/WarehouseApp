package com.sirgiyenko.App_warehouse.repository;

import com.sirgiyenko.App_warehouse.entity.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findAll();

    int create(Customer customer);

}
