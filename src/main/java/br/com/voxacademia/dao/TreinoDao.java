package br.com.voxacademia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.voxacademia.dto.TreinoAlunoDTO;
import br.com.voxacademia.model.Aluno;
import br.com.voxacademia.model.Professor;
import br.com.voxacademia.model.Treino;

/**
 * @author Rafaell Estevam
 *
 */
public class TreinoDao {

	private EntityManager em;

	public TreinoDao(EntityManager em) {
		this.em = em;
	}
	
	
	public void salvar(Treino treino) {
		em.getTransaction().begin();
		
		em.persist(treino);
		
		em.getTransaction().commit();
	}
	
	
	public void remover(Long id) {
		Treino treino = em.find(Treino.class, id);
		
		em.getTransaction().begin();
		
		em.remove(treino);
		
		em.getTransaction().commit();
		
	}
	
	
	public void atualizar(Treino treino) {
		em.getTransaction().begin();
		
		em.merge(treino);
		
		em.getTransaction().commit();
	}
	
	
	
	public Treino findById(Long id) {
		return em.find(Treino.class, id);
	}
	
	//TESTAR
	public List<Treino>findTreinosInativosProfessor(Professor professor){
		
		String jpql="select t from Treino t where t.professor= :professor and t.ativo = 'false'";
		
		TypedQuery<Treino> query = em.createQuery(jpql, Treino.class);
		return query.getResultList();
		
	}
	
	//Projeção TESTAR
	public List<TreinoAlunoDTO>findByAluno(Aluno aluno){
		
		String jpql="select new br.com.voxacademia.dto.TreinoAlunoDTO(t.id, t.titulo, t.dataCriacao, t.dataValidade) from Treino t where aluno = :aluno";
		
		TypedQuery<TreinoAlunoDTO> query = em.createQuery(jpql, TreinoAlunoDTO.class);
		query.setParameter("aluno", aluno);
		
		return query.getResultList();
		
	}
	
	
	
	
	//query dinâmica com vários filtros para o adm? 
	//query dinâmica com alguns filtros para o professor filtrar seus treinos? 

}
