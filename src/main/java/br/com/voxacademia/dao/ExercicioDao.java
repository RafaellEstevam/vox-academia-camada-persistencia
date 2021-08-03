package br.com.voxacademia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.voxacademia.model.Exercicio;
import br.com.voxacademia.model.GrupoMuscular;

/**
 * @author Rafaell Estevam
 *
 */
public class ExercicioDao {
	
	private EntityManager em;

	public ExercicioDao(EntityManager em) {
		this.em = em;
	}
	
	
	public void salvar(Exercicio exercicio) {
		em.getTransaction().begin();
		
		em.persist(exercicio);
		
		em.getTransaction().commit();
	}
	
	
	public void remover(Long id) {
		Exercicio exercicio = em.find(Exercicio.class, id);
		
		em.getTransaction().begin();
		
		em.remove(exercicio);
		
		em.getTransaction().commit();
		
	}
	
	
	public void atualizar(Exercicio exercicio) {
		em.getTransaction().begin();
		
		em.merge(exercicio);
		
		em.getTransaction().commit();
	}
	
	
	
	public Exercicio findById(Long id) {
		return em.find(Exercicio.class, id);
	}
	
	
	public List<Exercicio> findByGrupoMuscular(GrupoMuscular grupoMuscular){
		
		String jpql="select e from Exercicio e where e.grupoMuscular= : grupoMuscular";
		
		TypedQuery<Exercicio> query = em.createQuery(jpql, Exercicio.class);
		query.setParameter("grupoMuscular", grupoMuscular);
		
		return query.getResultList();		
		
	}
	
	
	
	
}
