package br.com.voxacademia.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.voxacademia.dao.filter.AulaFilter;
import br.com.voxacademia.model.Aula;
import br.com.voxacademia.model.Professor;

/**
 * @author Rafaell Estevam
 *
 */
public class AulaDao {

	private EntityManager em;

	public AulaDao(EntityManager em) {
		this.em = em;
	}

	
	//salvar
	public void salvar(Aula aula) {
		em.getTransaction().begin();
		
		em.persist(aula);
		
		em.getTransaction().commit();
	}
	
	
		
	//remover 
	public void remover(Long id) {
		Aula aula = em.find(Aula.class, id);
		
		em.getTransaction().begin();
		
		em.remove(aula);
		
		em.getTransaction().commit();
		
	}
	
	
	
	//atualizar
	public void atualizar(Aula aula) {
		em.getTransaction().begin();
		
		em.merge(aula);
		
		em.getTransaction().commit();
	}
	
	
		
	//buscar por id
	public Aula findById(Long id) {
		return em.find(Aula.class, id);
	}
	
	
		
	//buscar por nome(containing)
	public List<Aula>findByNome(String nome){
		
		String jpql="select a from Aula a join fetch a.professor where a.nome like concat('%',:nome, '%')";
		
		TypedQuery<Aula> query = em.createQuery(jpql, Aula.class);
		query.setParameter("nome", nome);
		
		return query.getResultList();	
	}
	
	
	
	//listar
	public List<Aula>findAll(){
		
		String jpql="select a from Aula a join fetch a.professor";
		
		TypedQuery<Aula> query = em.createQuery(jpql, Aula.class);
		
		return query.getResultList();
	}
	
	
	
	//listar aulas por professor
	public List<Aula>findByProfessor(Professor professor){
		
		String jpql="select a from Aula a where a.professor = :professor";
		
		TypedQuery<Aula> query = em.createQuery(jpql, Aula.class);
		query.setParameter("professor", professor);
		
		return query.getResultList();
	}
	
	
	
	//listar aulas por data
	public List<Aula>findByData(LocalDate data){
		
		String jpql="select a from Aula a where a.data = :data";
		
		TypedQuery<Aula> query = em.createQuery(jpql, Aula.class);
		query.setParameter("data", data);
		
		return query.getResultList();
	}
	
	
	//criteria query
	public List<Aula>filtrar(AulaFilter filtro){
		
		//select a from Aula a
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Aula> criteriaQuery = builder.createQuery(Aula.class);
		Root<Aula> root = criteriaQuery.from(Aula.class);
		
		
		List<Predicate>predicates = new ArrayList<Predicate>();
		
		
		if(filtro != null) {
			
			if(filtro.getTitulo() != null) { // (where) a.titulo = :titulo
				Predicate predicate = builder.equal(root.get("titulo"), filtro.getTitulo());
				predicates.add(predicate);
			}
			
			
			if(filtro.getData() != null) { // (where) a.data = :data
				Predicate predicate = builder.equal(root.get("data"), filtro.getData());
				predicates.add(predicate);
			}
			
			
			if(filtro.getHoraInicio() != null) { // (where) a.horaInicio >= :horaInicio
				Predicate predicate = builder.greaterThanOrEqualTo((Expression)root.get("horaInicio"), filtro.getHoraInicio());
				predicates.add(predicate);
			}
			
			if(filtro.getHoraFim() != null) { // (where) a.horaFim <= :horaFim
				Predicate predicate = builder.lessThanOrEqualTo((Expression)root.get("horaFim"), filtro.getHoraFim());
				predicates.add(predicate);
			}
			
			
			if(filtro.getProfessor() != null) {// (where) a.professor = :professor
				Predicate predicate = builder.equal(root.get("professor"), filtro.getProfessor());
				predicates.add(predicate);
			}
			
		}
		
		
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		
		TypedQuery<Aula> query = em.createQuery(criteriaQuery);
		
		return query.getResultList();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
