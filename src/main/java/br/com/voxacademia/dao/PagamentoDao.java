package br.com.voxacademia.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.voxacademia.dto.PagamentoDTO;
import br.com.voxacademia.dto.MediaMensalPagamentoDTO;
import br.com.voxacademia.model.Aluno;
import br.com.voxacademia.model.Pagamento;

/**
 * @author Rafaell Estevam
 *
 */
public class PagamentoDao {

	
	private EntityManager em;

	public PagamentoDao(EntityManager em) {
		this.em = em;
	}
	
	
	
	//salvar
	public void salvar(Pagamento compra) {
		em.getTransaction().begin();
		
		em.persist(compra);
		
		em.getTransaction().commit();
	}
	
	
	
	//buscar por id
	public Pagamento findById(Long id) {
		return em.find(Pagamento.class, id);
	}
	
	

	//listar todos 
	public List<Pagamento>findAll(){
		
		String jpql="select c from Pagamento c join fetch c.plano join fetch c.aluno";
		
		TypedQuery<Pagamento> query = em.createQuery(jpql, Pagamento.class);
		return query.getResultList();
	}
	
	
	//buscar compras por aluno
	public List<Pagamento>findByAluno(Aluno aluno){
		
		String jpql="select c from Pagamento c where c.aluno = :aluno";
		
		TypedQuery<Pagamento> query = em.createQuery(jpql, Pagamento.class);		
		query.setParameter("aluno", aluno);
		return query.getResultList();
	}
	
	
	//listar compras realizadas em determinado período(projeção) TESTAR!
	public List<PagamentoDTO> findByDataBetween(LocalDate dataInicio, LocalDate dataFim){
		
		LocalDateTime data1 = LocalDateTime.of(dataInicio, LocalTime.MIN);
		LocalDateTime data2 = LocalDateTime.of(dataFim, LocalTime.MAX);
		
		
		String jpql="select new br.com.voxacademia.dto.PagamentoDTO(c.valor, c.data, c.aluno.nome) from Pagamento c where c.data between :data1 and :data2";
		
		TypedQuery<PagamentoDTO> query = em.createQuery(jpql, PagamentoDTO.class);
		query.setParameter("data1", data1);
		query.setParameter("data2", data2);

		return query.getResultList();

	}
	

	
	//Soma do valor das compras realizadas em determinado período
	public BigDecimal getSum(LocalDate dataInicio, LocalDate dataFim) {
		
		LocalDateTime data1 = LocalDateTime.of(dataInicio, LocalTime.MIN);	
		LocalDateTime data2 = LocalDateTime.of(dataInicio, LocalTime.MAX);	
		
		
		String jpql="select sum(valor) from Pagamento c where c.data between :data1 and :data2";
		
		TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
		query.setParameter("data1", data1);
		query.setParameter("data2", data2);
		return query.getSingleResult();
		
	}
	
	
	//Media mensal das compras realizadas dentro de um determinado período
	public List<MediaMensalPagamentoDTO> getMedia(LocalDate dataInicio, LocalDate dataFim) {
		 
		LocalDateTime data1 = LocalDateTime.of(dataInicio, LocalTime.MIN);	
		LocalDateTime data2 = LocalDateTime.of(dataInicio, LocalTime.MAX);	
		
		String jpql="select new br.com.voxacademia.dto.MediaMensalPagamentoDTO(month(c.data), year(c.data), avg(valor)) "
				+ "from Pagamento c where c.data between :data1 and :data2 group by month(c.data), year(c.data)";
		
		TypedQuery<MediaMensalPagamentoDTO> query = em.createQuery(jpql, MediaMensalPagamentoDTO.class);
		query.setParameter("data1", data1);
		query.setParameter("data2", data2);
		
		return query.getResultList();
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
}
