package br.com.voxacademia.dao.filter;

import java.time.LocalDate;

/**
 * @author Rafaell Estevam
 *
 */
public class AlunoFilter {

	private String nome;
	private String cpf;
	private LocalDate dataNascimentoDe;
	private LocalDate dataNascimentoAte;
	private String email;
	private String telefone;

	/**
	 * 
	 */
	public AlunoFilter() {
		// TODO Auto-generated constructor stub
	}

	public AlunoFilter(String nome, String cpf, LocalDate dataNascimentoDe, LocalDate dataNascimentoAte, String email,
			String telefone) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimentoDe = dataNascimentoDe;
		this.dataNascimentoAte = dataNascimentoAte;
		this.email = email;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimentoDe() {
		return dataNascimentoDe;
	}

	public void setDataNascimentoDe(LocalDate dataNascimentoDe) {
		this.dataNascimentoDe = dataNascimentoDe;
	}

	public LocalDate getDataNascimentoAte() {
		return dataNascimentoAte;
	}

	public void setDataNascimentoAte(LocalDate dataNascimentoAte) {
		this.dataNascimentoAte = dataNascimentoAte;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
