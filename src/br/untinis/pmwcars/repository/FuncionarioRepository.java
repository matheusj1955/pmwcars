package br.untinis.pmwcars.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.pmwcars.application.JPAUtil;
import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.model.Funcionario;

public class FuncionarioRepository {

	public void save(Funcionario funcionario) throws RepositoryException {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			
			em.getTransaction().begin();
			
			// insert or update
			em.merge(funcionario);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao executar o método Save do Repository");
			throw new RepositoryException("Erro ao Salvar");
		}
		
	}
	
	public void remove(Funcionario funcionario) throws RepositoryException {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			
			em.getTransaction().begin();
			
			// insert or update
			em.remove(funcionario);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao executar o método Remove do Repository");
			throw new RepositoryException("Erro ao Remover");
		}
	}
	
	public List<Funcionario> findAll() throws RepositoryException {
		EntityManager em = JPAUtil.getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" p ");
		jpql.append("FROM ");
		jpql.append(" Funcionario p ");
		jpql.append("ORDER BY p.nome ");
		
		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
		 
	}

	public Funcionario findId(Funcionario funcionario) throws RepositoryException {
		EntityManager em = JPAUtil.getEntityManager();
		return em.find(funcionario.getClass(), funcionario.getId());
	}

	
}
