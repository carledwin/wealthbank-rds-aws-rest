package com.wealthbank.rds.aws.rest.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WealthBankRestController {

	@GetMapping
	public String home() {
		return  "Bem vindo ao Wealth Bank!";
	}
}
