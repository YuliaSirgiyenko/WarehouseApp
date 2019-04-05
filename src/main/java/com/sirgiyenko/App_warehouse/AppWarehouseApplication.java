package com.sirgiyenko.App_warehouse;

import com.sirgiyenko.App_warehouse.service.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class AppWarehouseApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AppWarehouseApplication.class, args);

		CustomerService service = context.getBean(CustomerService.class);
		System.out.println(service.getAllCustomers());

		service.createCustomer("Loki", "Dinn", "XXX", "ACTIVE");

	}

}
