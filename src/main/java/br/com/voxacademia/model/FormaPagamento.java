package br.com.voxacademia.model;

/**
 * @author Rafaell Estevam
 *
 */
public enum FormaPagamento {
	DINHEIRO("Dinheiro"), CREDITO("Crédito"), DEBITO("Débito");

	private String descricao;

	private FormaPagamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
