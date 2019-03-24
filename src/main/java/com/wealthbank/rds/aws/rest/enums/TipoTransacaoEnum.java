package com.wealthbank.rds.aws.rest.enums;

public enum TipoTransacaoEnum {

	PAGAMENTO(1, "Pagamento"), DEBITO(2, "Débito"), CREDITO(3, "Crédito"), TED(4, "Ted"), DOC(5, "Doc"), BOLETO(6, "Boleto"), TITULO(7, "Título");
	
	private int codigo;
	private String descricao;
	
	private TipoTransacaoEnum(int codigo, String descricao) {
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
