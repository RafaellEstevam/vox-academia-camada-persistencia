package br.com.voxacademia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.voxacademia.model.Estado;

/**
 * @author Rafaell Estevam
 *
 */
public class EstadoDao {

	
	private EntityManager em;

	public EstadoDao(EntityManager em) {
		this.em = em;
	}
	
	
	
	public void salvar(Estado estado) {
		em.getTransaction().begin();
		
		em.persist(estado);
		
		em.getTransaction().commit();
	}
	

	public List<Estado>findAll(){
		
		String jpql = "select e from Estado e";
		
		TypedQuery<Estado> query = em.createQuery(jpql, Estado.class);
		
		return query.getResultList();
		
	}
	
	
	
	
	
	
}
