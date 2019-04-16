package com.sirgiyenko.App_warehouse.service;

import com.sirgiyenko.App_warehouse.entity.ProductOwner;

import java.util.List;

/**
 * Represents part of application described business logic for product owners
 * processing.
 */
public interface ProductOwnerService {

    /**
     * Get all active product owners.
     * @return ArrayList of ProductOwners.
     */
    List<ProductOwner> getAllProductOwners();

    /**
     * Create of new product owner.
     * @param firstName
     * @param lastName
     * @param company
     * @param status
     * @return ProductOwner entity.
     */
    ProductOwner createProductOwner(String firstName, String lastName, String company, String status);

}
