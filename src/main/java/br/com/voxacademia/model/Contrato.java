package br.com.voxacademia.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Rafaell Estevam
 *
 */
@Entity
public class Contrato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer numero;
	private LocalDate dataContratacao;
	private LocalDate validade;

	@ManyToOne
	private Plano plano;

	@OneToMany(mappedBy = "contrato", cascade = CascadeType.REMOVE)
	private List<Pagamento> pagamentos;

	public Contrato() {
		// TODO Auto-generated constructor stub
	}

	public Contrato(LocalDate dataContratacao, LocalDate validade, Plano plano) {
		this.dataContratacao = dataContratacao;
		this.validade = validade;
		this.plano = plano;
		//this.gerarNumero(); METODO QUE VAI GERAR NUMERO DO CONTRATO E VER SE ELE EXISTE NO BD. FAZER DEPOIS
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public LocalDate getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(LocalDate dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

}
