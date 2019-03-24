package com.wealthbank.rds.aws.rest.enums;

public enum TipoContaEnum {

CORRENTE(1, "Corrente"), POUPANCA(2, "Poupança");
	
	private int codigo;
	private String descricao;
	
	private TipoContaEnum(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

}
