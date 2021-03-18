package br.unitins.pmwcars.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unitins.pmwcars.model.Usuario;

public class TesteJPA {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pmwcars");
		EntityManager em = emf.createEntityManager();
		
		Usuario usuario = new Usuario();
		usuario.setId(2);
		usuario.setCpf("111");
		usuario.setNome("Joao");
		
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		
		System.out.println("Funcionou.");
	}
}
