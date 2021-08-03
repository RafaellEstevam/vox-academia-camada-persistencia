package br.com.voxacademia.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Rafaell Estevam
 *
 */
public class PagamentoDTO {

	private BigDecimal valor;
	private LocalDateTime data;
	private String aluno;

	public PagamentoDTO(BigDecimal valor, LocalDateTime data, String aluno) {
		super();
		this.valor = valor;
		this.data = data;
		this.aluno = aluno;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getAluno() {
		return aluno;
	}

	public void setAluno(String aluno) {
		this.aluno = aluno;
	}
	

}
