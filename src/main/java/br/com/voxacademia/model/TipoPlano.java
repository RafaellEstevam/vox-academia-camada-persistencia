package br.com.voxacademia.model;

/**
 * @author Rafaell Estevam
 *
 */
public enum TipoPlano {
	MENSAL("Mensal"), SEMESTRAL("Semestral"), ANUAL("Anual");

	private String descricao;

	private TipoPlano(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
