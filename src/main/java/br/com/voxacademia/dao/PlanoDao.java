package br.com.voxacademia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.voxacademia.model.Plano;

/**
 * @author Rafaell Estevam
 *
 */
public class PlanoDao {

	
	private EntityManager em;
	
	
	
	public PlanoDao(EntityManager em) {
		this.em = em;
	}
	
	
	
	//salvar
	public void salvar(Plano plano) {
		
		em.getTransaction().begin();
		
		em.persist(plano);
		
		em.getTransaction().commit();
	}
	
	
	//remover
	public void remover(Long id) {
		
		Plano plano = em.find(Plano.class, id);
		
		em.getTransaction().begin();
		
		em.remove(plano);
		
		em.getTransaction().commit();
	}
		
	
	//atualizar
	public void atualizar(Plano plano) {
		
		em.getTransaction().begin();
		
		em.merge(plano);
		
		em.getTransaction().commit();
	}
	
	
	//buscarPorId
	public Plano findById(Long id) {
		
		return em.find(Plano.class, id);
	}
	
	
	
	
	//listar
	public List<Plano>findAll(){
		
		String jpql="select p from Plano p";
		
		TypedQuery<Plano> query = em.createQuery(jpql, Plano.class);
		
		return query.getResultList();
		
	}
	
	
	
}
