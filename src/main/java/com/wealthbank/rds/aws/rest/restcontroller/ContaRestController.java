package com.wealthbank.rds.aws.rest.restcontroller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wealthbank.rds.aws.rest.enums.TipoContaEnum;
import com.wealthbank.rds.aws.rest.model.Conta;
import com.wealthbank.rds.aws.rest.model.Correntista;
import com.wealthbank.rds.aws.rest.model.Usuario;
import com.wealthbank.rds.aws.rest.repository.ContaRepository;

@RestController
@RequestMapping("/conta")
public class ContaRestController {

	@Autowired
	private ContaRepository contaRepository;

	@GetMapping("/all")
	public ResponseEntity<?> all() {
		
		Iterable<Conta> todasContas = contaRepository.findAll();
		return new ResponseEntity<Iterable<Conta>>(todasContas, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable(required = true) Long id) {

		Optional<Conta> optionalConta = contaRepository.findById(id);

		if (optionalConta != null && optionalConta.isPresent()) {
			return new ResponseEntity<Conta>(optionalConta.get(), HttpStatus.OK);
		}

		return new ResponseEntity<String>("Conta não encontrada.", HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Conta conta) {
		
		try {
			
			conta = contaRepository.save(conta);
			
			if (conta != null) {
				return new ResponseEntity<Conta>(conta, HttpStatus.CREATED);
			}
			
			return new ResponseEntity<String>("Não foi possível salvar conta", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<String>("Falha ao tentar salvar conta." + " Message: " + e.getMessage() + " Cause: " + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody Conta conta) {

		if (conta.getId() != null) {
			
			Optional<Conta> optionalConta = contaRepository.findById(conta.getId());

			if (optionalConta != null && optionalConta.get() != null
					&& conta.getId().equals(optionalConta.get().getId())) {
				Conta contaToUpdate = optionalConta.get();
				contaToUpdate = conta;
				conta = contaRepository.save(contaToUpdate);
				return new ResponseEntity<String>("Conta atualizada com sucesso", HttpStatus.NO_CONTENT);
			}
		}

		return new ResponseEntity<String>("Conta não conta encontrada para a atualização.", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{agencia}/{numero}")
	public ResponseEntity<?> delete(@PathVariable(required = true) Integer agencia, @PathVariable(required = true) Long numero) {

		Conta conta = contaRepository.findByAgenciaAndNumero(agencia, numero);

		if (conta != null) {
			contaRepository.deleteById(conta.getId());
			return new ResponseEntity<String>("Conta excluída com sucesso", HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<String>("Conta não conta encontrada para a exclusão.", HttpStatus.NOT_FOUND);
	}
}
