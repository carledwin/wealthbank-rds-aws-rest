package com.wealthbank.rds.aws.rest.restcontroller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wealthbank.rds.aws.rest.model.Comprovante;

@RestController
@RequestMapping("/emissaocomprovante")
public class WealthBankRestController {

	@PostMapping
	public void salva(@RequestBody Comprovante comprovante) {
		
	}
}
