package br.com.voxacademia.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.voxacademia.dao.filter.AlunoFilter;
import br.com.voxacademia.model.Aluno;

/**
 * @author Rafaell Estevam
 *
 */
public class AlunoDao {
	
	
	private EntityManager em;

	public AlunoDao(EntityManager em) {
		this.em = em;
	}
	
	
	
	
	//salvar
	public void salvar(Aluno aluno) {
		em.getTransaction().begin();
		
		em.persist(aluno);
		
		em.getTransaction().commit();
	}
	
	
	//remover
	public void remover(Long id) {
		
		Aluno aluno = em.find(Aluno.class, id);
		
		em.getTransaction().begin();
		
		em.remove(aluno);
		
		em.getTransaction().commit();
		
	}
	
	
	//atualizar
	public void atualizar(Aluno aluno) {
		em.getTransaction().begin();
		
		em.merge(aluno);
		
		em.getTransaction().commit();
	}
	

	//buscarPorId
	public Aluno findById(Long id) {
		return em.find(Aluno.class, id);
	}
	
	
	
	//buscar por nome (containing)
	public List<Aluno>findByNomeContaining(String nome){
		
		String jpql="select a from Aluno a where a.nome like concat('%',:nome, '%')";
		
		TypedQuery<Aluno> query = em.createQuery(jpql, Aluno.class);
		query.setParameter("nome", nome);
		
		return query.getResultList();
		
	}
	
	
	//buscar por cpf
	public Aluno findByCpf(String cpf) {
		
		String jpql="select a from Aluno a where a.cpf = :cpf";
		
		TypedQuery<Aluno> query = em.createQuery(jpql, Aluno.class);
		query.setParameter("cpf", cpf);
		
		return query.getSingleResult();
	}
	

	
	//listar
	public List<Aluno>findAll(){
		
		String jpql="select a from Aluno a join fetch a.plano join fetch a.endereco";
		
		TypedQuery<Aluno> query = em.createQuery(jpql, Aluno.class);
		
		return query.getResultList();
		
	}
	
	
	//criteria query
	public List<Aluno>filtrar(AlunoFilter filtro){
		
		//select a from Aluno a
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Aluno> criteriaQuery = builder.createQuery(Aluno.class);
		Root<Aluno> root = criteriaQuery.from(Aluno.class);
		
		List<Predicate>predicates = new ArrayList<Predicate>();
		
		if(filtro != null) {
			
			//a.nome = :nome
			if(!filtro.getNome().isEmpty()) {
				Predicate predicate = builder.equal(root.get("nome"), filtro.getNome());
				predicates.add(predicate);
			}			
			
			//a.cpf = :cpf
			if(!filtro.getCpf().isEmpty()) {
				Predicate predicate = builder.equal(root.get("cpf"), filtro.getCpf());
				predicates.add(predicate);
			}			
			
			
			//a.dataNascimento >= :dataNascimento
			if(filtro.getDataNascimentoDe() != null) {
				Predicate predicate = builder.greaterThanOrEqualTo((Expression) root.get("dataNascimento"), filtro.getDataNascimentoDe());
				predicates.add(predicate);
			}
			
			//a.dataNascimento <= :dataNascimento
			if(filtro.getDataNascimentoAte() != null) {
				Predicate predicate = builder.lessThanOrEqualTo((Expression) root.get("dataNascimento"), filtro.getDataNascimentoAte());
				predicates.add(predicate);
			}
			
			
			//a.email = :email
			if(!filtro.getEmail().isEmpty()) {
				Predicate predicate = builder.equal(root.get("email"), filtro.getEmail());
				predicates.add(predicate);
			}			
			
			
			//a.telefone = :telefone
			if(!filtro.getTelefone().isEmpty()) {
				Predicate predicate = builder.equal(root.get("telefone"), filtro.getTelefone());
				predicates.add(predicate);
			}			
			
			
		}
		
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		TypedQuery<Aluno> query = em.createQuery(criteriaQuery);
		
		return query.getResultList();
	}
	
	
}
