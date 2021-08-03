package br.com.voxacademia.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Rafaell Estevam
 *
 */
public class MainTest {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vox_academia");
		EntityManager em = emf.createEntityManager();
	
		
	}
}
