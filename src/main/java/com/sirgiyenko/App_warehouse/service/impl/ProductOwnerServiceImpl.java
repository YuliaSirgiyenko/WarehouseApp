package com.sirgiyenko.App_warehouse.service.impl;

import com.sirgiyenko.App_warehouse.entity.ProductOwner;
import com.sirgiyenko.App_warehouse.repository.ProductOwnerRepository;
import com.sirgiyenko.App_warehouse.service.ProductOwnerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductOwnerServiceImpl implements ProductOwnerService {

    private final ProductOwnerRepository productOwnerRepository;

    public ProductOwnerServiceImpl(ProductOwnerRepository productOwnerRepository) {
        this.productOwnerRepository = productOwnerRepository;
    }

    @Override
    public List<ProductOwner> getAllProductOwners() {
        return productOwnerRepository.findAll();
    }

    @Override
    @Transactional
    public ProductOwner createProductOwner(String firstName, String lastName, String company, String status) {
        ProductOwner productOwner = new ProductOwner();
        productOwner.setFirstName(firstName);
        productOwner.setLastName(lastName);
        productOwner.setCompany(company);
        productOwner.setStatus(status);
        productOwnerRepository.create(productOwner);
        return productOwner;
    }

}
