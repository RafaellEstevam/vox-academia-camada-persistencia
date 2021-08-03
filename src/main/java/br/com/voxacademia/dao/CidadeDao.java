package br.com.voxacademia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.voxacademia.model.Cidade;
import br.com.voxacademia.model.Estado;

/**
 * @author Rafaell Estevam
 *
 */
public class CidadeDao {

	private EntityManager em;
	
	
	public CidadeDao(EntityManager em) {
		this.em = em;
	}
	
	
	
	public void salvar(Cidade cidade){
		em.getTransaction().begin();
		
		em.persist(cidade);
		
		em.getTransaction().commit();
	}
	
	
	public void remover(Long id) {
		
		Cidade cidade = em.find(Cidade.class, id);
		
		em.getTransaction().begin();
		
		em.remove(cidade);
		
		em.getTransaction().commit();
	}
	
	
	public List<Cidade>findByEstado(Estado estado){
				
		String jpql="select c from Cidade c where c.estado = :estado";
		
		TypedQuery<Cidade> query = em.createQuery(jpql, Cidade.class);
		query.setParameter("estado", estado);
		return query.getResultList();
		
		
	}
	
	
	public Cidade findById(Long id) {
		return em.find(Cidade.class, id);
	}
	
	
}
