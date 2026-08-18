package com.desenvolvimento.logica.stockpilot.stockpilot_auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {
				"com.desenvolvimento.logica.stockpilot"
		}
)public class StockpilotAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockpilotAuthApplication.class, args);
	}

}
