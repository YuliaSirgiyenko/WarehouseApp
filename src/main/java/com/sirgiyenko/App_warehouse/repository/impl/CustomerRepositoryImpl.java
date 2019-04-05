package com.sirgiyenko.App_warehouse.repository.impl;

import com.sirgiyenko.App_warehouse.entity.Customer;
import com.sirgiyenko.App_warehouse.repository.CustomerRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final EntityManager entityManager;

    public CustomerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Customer> findAll() {
        return entityManager
                .createQuery("from Customer", Customer.class).getResultList();
    }

    @Override
    public int create(Customer customer) {
        entityManager.persist(customer);
        entityManager.flush();
        return customer.getId();
    }


}
