package com.sirgiyenko.App_warehouse.repository;

import com.sirgiyenko.App_warehouse.entity.ProductOwner;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

/**
 * Represents part of application responsible for product owners data adding/retrieving
 * to/from DB.
 */
public interface ProductOwnerRepository {

    /**
     * Get all active product owners from DB.
     * @return ArrayList of ProductOwners.
     */
    List<ProductOwner> findAll();

    /**
     * Add of new product owner to DB.
     * @param productOwner - ProductOwner entity.
     * @return id of added productOwner.
     * @throws org.springframework.dao.DataIntegrityViolationException if DB reject adding due to non-unique
     * firstName and lastName of productOwner.
     */
    int create(ProductOwner productOwner) throws DataIntegrityViolationException;

}
