package com.wealthbank.rds.aws.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.wealthbank.rds.aws.rest.enums.TipoContaEnum;

@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private TipoContaEnum tipoConta;

	@Column(length = 5)
	@Size(min = 1, max = 5)
	private Integer agencia;

	@Column(length = 8)
	@Size(min = 1, max = 8)
	private Long numero;

	@Column(length = 1)
	@Size(min = 1, max = 1)
	private Short digito;

	@ManyToOne
	private Correntista correntista;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoContaEnum getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoContaEnum tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Short getDigito() {
		return digito;
	}

	public void setDigito(Short digito) {
		this.digito = digito;
	}

	public Correntista getCorrentista() {
		return correntista;
	}

	public void setCorrentista(Correntista correntista) {
		this.correntista = correntista;
	}

}
