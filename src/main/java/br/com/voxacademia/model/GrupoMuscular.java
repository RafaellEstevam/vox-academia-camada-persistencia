package br.com.voxacademia.model;

/**
 * @author Rafaell Estevam
 *
 */
public enum GrupoMuscular {
	PEITO("Peito"), BICEPS("Bíceps"), COSTAS("Costas"), TRICEPS("Tríceps"), OMBRO("Ombro"), PERNA("Perna"),
	GLUTEOS("Glúteos"), LOMBAR("Lombar"), ABDOMEN("Abdômen");

	private String descricao;

	private GrupoMuscular(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
