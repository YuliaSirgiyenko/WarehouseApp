package com.sirgiyenko.App_warehouse.service.impl;

import com.sirgiyenko.App_warehouse.entity.ProductOwner;
import com.sirgiyenko.App_warehouse.enums.MessagesForDataFilling;
import com.sirgiyenko.App_warehouse.exceptions.FilledDataException;
import com.sirgiyenko.App_warehouse.repository.ProductOwnerRepository;
import com.sirgiyenko.App_warehouse.service.ProductOwnerService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static jdk.nashorn.internal.objects.NativeString.trim;

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
    public ProductOwner createProductOwner(String firstName, String lastName, String company) {
        ProductOwner productOwner = new ProductOwner();

        if (trim(firstName) == "" | trim(lastName) == "") {
            throw new FilledDataException(MessagesForDataFilling.EMPTY_NAME);
        } else {
            productOwner.setFirstName(firstName);
            productOwner.setLastName(lastName);
            productOwner.setCompany(company);
            productOwner.setStatus("ACTIVE");

            try {
                productOwnerRepository.create(productOwner);
            } catch (DataIntegrityViolationException e) {
                throw new FilledDataException(MessagesForDataFilling.DUPLICATE_OWNER);
            }

            return productOwner;
        }
    }

}
