package br.com.voxacademia.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.voxacademia.model.Professor;

/**
 * @author Rafaell Estevam
 *
 */
public class ProfessorDao {

	
	private EntityManager em;

	
	public ProfessorDao(EntityManager em) {
		this.em = em;
	}
	
	
	
	//salvar
	public void salvar(Professor professor) {
		em.getTransaction().begin();
		
		em.persist(professor);
		
		em.getTransaction().commit();
	}
	

	//remover
	public void remover(Long id) {
		Professor professor = em.find(Professor.class, id);
		
		em.getTransaction().begin();
		
		em.remove(professor);
		
		em.getTransaction().commit();
		
	}
	
	
	//atualizar
	public void atualizar(Professor professor) {
		em.getTransaction().begin();
		
		em.merge(professor);
		
		em.getTransaction().commit();
	}
	
	
	
	//buscar por id
	public Professor findById(Long id) {
		return em.find(Professor.class, id);
	}
	
	
	//buscar por cref
	public Professor findByCref(String cref) {
		
		String jpql="select p from Professor p where p.cref = :cref";
		
		TypedQuery<Professor> query = em.createQuery(jpql, Professor.class);
		query.setParameter("cref", cref);
		
		return query.getSingleResult();
	}
	
	
	//buscar por nome(containing)
	public List<Professor>findByNomeContaining(String nome){
		
		String jpql="select p from Professor p where p.nome like concat('%',:nome,'%')";
		
		TypedQuery<Professor> query = em.createQuery(jpql, Professor.class);
		query.setParameter("nome", nome);
		
		return query.getResultList();
		
	}
		
		
		
	//listar
	public List<Professor>findAll(){
		
		String jpql="select p from Professor p join fetch p.endereco";
		
		TypedQuery<Professor> query = em.createQuery(jpql, Professor.class);
	
		return query.getResultList(); 
	}
	
	
	//buscar por salario(between)
	public List<Professor>findBySalarioBetween(BigDecimal valorMin, BigDecimal valorMax){
		
		String jpql="select p from Professor p where p.salario between :valorMin and valorMax";
		
		TypedQuery<Professor> query = em.createQuery(jpql, Professor.class);
		query.setParameter("valorMin", valorMin); 
		query.setParameter("valorMax", valorMax);
		
		return query.getResultList();
	}
	
	
	
	//buscar por data contratacao(between)
	public List<Professor>findByDataContratacaoBetween(LocalDate dataMin, LocalDate dataMax){
		
		String jpql="select p from Professor p where p.dataContratacao between :dataMin and dataMax";
		
		TypedQuery<Professor> query = em.createQuery(jpql, Professor.class);
		query.setParameter("dataMin", dataMin); 
		query.setParameter("dataMax", dataMax);
		
		return query.getResultList();
	}
		
	
	
	
	
	
	
	
	
	
}
