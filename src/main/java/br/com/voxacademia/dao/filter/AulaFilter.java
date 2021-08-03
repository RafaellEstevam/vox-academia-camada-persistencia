package br.com.voxacademia.dao.filter;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.voxacademia.model.Professor;

/**
 * @author Rafaell Estevam
 *
 */
public class AulaFilter {

	private String titulo;

	private LocalDate data;

	private LocalTime horaInicio;

	private LocalTime horaFim;

	private Professor professor;

	
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(LocalTime horaFim) {
		this.horaFim = horaFim;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

}
