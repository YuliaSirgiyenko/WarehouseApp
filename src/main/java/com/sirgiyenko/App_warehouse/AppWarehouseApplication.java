package com.sirgiyenko.App_warehouse;

import com.sirgiyenko.App_warehouse.service.ProductOwnerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AppWarehouseApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AppWarehouseApplication.class, args);

		//ProductOwnerService service = context.getBean(ProductOwnerService.class);
		//service.createProductOwner("", "Dinn", "XXX");

	}

}
