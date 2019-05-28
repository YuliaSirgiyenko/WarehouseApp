package com.sirgiyenko.App_warehouse.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sirgiyenko.App_warehouse.entity.ProductOwner;
import com.sirgiyenko.App_warehouse.enums.MessagesForDataFilling;
import com.sirgiyenko.App_warehouse.exceptions.FilledDataException;
import com.sirgiyenko.App_warehouse.repository.ProductOwnerRepository;
import com.sirgiyenko.App_warehouse.service.ProductOwnerService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

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
     * @return line in json.
     */
    @GetMapping("/get-all-owners")
    public String toJSON() throws IOException {
        List<ProductOwner> allProductOwners = productOwnerService.getAllProductOwners();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(allProductOwners);
    }

    /**
     * Initial parameters - data of new product owner from web in json.
     * Action - submission of new product owner to DB via ProductOwnerService.
     * @return string message about successful adding or mistake.
     */
    @PostMapping(value = "/add-new-owner", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    public String submitNewOwner(ProductOwner productOwner){
        try {
            productOwnerService.createProductOwner(productOwner.getFirstName(),
                    productOwner.getLastName(), productOwner.getCompany());
            return MessagesForDataFilling.SUCCESS_OWNER_ADD.getMessage();
        } catch (FilledDataException e) {
            return e.getExceptionMessage();
        }
    }

}
