package com.sirgiyenko.App_warehouse.repository.impl;

import com.sirgiyenko.App_warehouse.entity.ProductOwner;
import com.sirgiyenko.App_warehouse.repository.ProductOwnerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProductOwnerRepositoryImpl implements ProductOwnerRepository {

    private final EntityManager entityManager;

    public ProductOwnerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<ProductOwner> findAll() {
        return entityManager
                .createQuery("from ProductOwner", ProductOwner.class).getResultList();
    }

    @Override
    public int create(ProductOwner productOwner) {
        entityManager.persist(productOwner);
        entityManager.flush();
        return productOwner.getId();
    }


}
