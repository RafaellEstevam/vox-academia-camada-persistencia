package br.com.voxacademia.dao;

import javax.persistence.EntityManager;

import br.com.voxacademia.model.Atividade;
import br.com.voxacademia.model.Treino;

/**
 * @author Rafaell Estevam
 *
 */
public class AtividadeDao {
	
	private EntityManager em;

	public AtividadeDao(EntityManager em) {
		this.em = em;
	}
	
	
	public void salvar(Treino treino) {
		em.getTransaction().begin();
		
		em.persist(treino);
		
		em.getTransaction().commit();
	}
	
	
	public void remover(Long id) {
		Atividade atividade = em.find(Atividade.class, id);
		
		em.getTransaction().begin();
		
		em.remove(atividade);
		
		em.getTransaction().commit();
		
	}
	
	
	public void atualizar(Atividade atividade) {
		em.getTransaction().begin();
		
		em.merge(atividade);
		
		em.getTransaction().commit();
	}
	
	
	
	public Atividade findById(Long id) {
		return em.find(Atividade.class, id);
	}
	
	
}
