package br.untinis.pmwcars.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.pmwcars.application.JPAUtil;
import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.model.Funcionario;

public class FuncionarioRepository extends Repository<Funcionario> {

	public FuncionarioRepository() {
		super(JPAUtil.getEntityManager());
	}
	
	public FuncionarioRepository(EntityManager em) {
		super(em);
	}
	

	public List<Funcionario> findAll() throws RepositoryException{ 
		
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" u ");
		jpql.append("FROM ");
		jpql.append(" Funcionario u ");
		jpql.append("ORDER BY u.funcionario.nome ");
		
		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
	}
	
	public Funcionario findFuncionario(String login, String senha) throws RepositoryException{ 
		
		try {
			EntityManager em = getEntityManager();
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append("  u ");
			jpql.append("FROM ");
			jpql.append("  Funcionario u ");
			jpql.append("WHERE ");
			jpql.append("  u.login = :login ");
			jpql.append("  AND u.senha = :senha ");
			
			Query query = em.createQuery(jpql.toString());
			query.setParameter("login", login);
			query.setParameter("senha", senha);
			
			return (Funcionario) query.getSingleResult();
			
		} catch (Exception e) {
			System.out.println("Erro ao realizar uma consulta ao banco.");
			e.printStackTrace();
			return null;
		}
		
	}
}
