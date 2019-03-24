package com.wealthbank.rds.aws.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wealthbank.rds.aws.rest.model.Conta;

@Repository
public interface ContaRepository extends CrudRepository<Conta, Long>{

	Conta findByAgenciaAndNumero(Integer agencia, Long numero);
}
