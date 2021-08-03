package br.com.voxacademia.dto;

/**
 * @author Rafaell Estevam
 *
 */
public class MediaMensalPagamentoDTO {

	private Integer mes;
	private Integer ano;
	private Double media;

	public MediaMensalPagamentoDTO(Integer mes, Integer ano, Double media) {
		super();
		this.mes = mes;
		this.ano = ano;
		this.media = media;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Double getMedia() {
		return media;
	}

	public void setMedia(Double media) {
		this.media = media;
	}

}
