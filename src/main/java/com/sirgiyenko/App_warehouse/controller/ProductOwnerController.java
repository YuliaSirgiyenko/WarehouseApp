package com.sirgiyenko.App_warehouse.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sirgiyenko.App_warehouse.entity.ProductOwner;
import com.sirgiyenko.App_warehouse.repository.ProductOwnerRepository;
import com.sirgiyenko.App_warehouse.service.ProductOwnerService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * Represents part of application responsible for interaction of ProductOwner entity
 * with web.
 */

@Service
@RestController
public class ProductOwnerController {

    private final ProductOwnerRepository productOwnerRepository;
    private final ProductOwnerService productOwnerService;

    ProductOwnerController(ProductOwnerRepository productOwnerRepository, ProductOwnerService productOwnerService){
        this.productOwnerRepository = productOwnerRepository;
        this.productOwnerService = productOwnerService;
    }

    /**
     * Get all active product owners as answer for web-request.
     * @return line in json format.
     */
    @RequestMapping("/get-all-owners")
    public String toJSON() throws IOException {
        List<ProductOwner> allProductOwners = productOwnerService.getAllProductOwners();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(allProductOwners);
    }

}
