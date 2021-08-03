package br.com.voxacademia.dto;

import java.time.LocalDate;

/**
 * @author Rafaell Estevam
 *
 */
public class TreinoAlunoDTO {

	private Long id;
	private String titulo;
	private LocalDate dataCriacao;
	private LocalDate dataValidade;

	public TreinoAlunoDTO(Long id, String titulo, LocalDate dataCriacao, LocalDate dataValidade) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.dataCriacao = dataCriacao;
		this.dataValidade = dataValidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

}
