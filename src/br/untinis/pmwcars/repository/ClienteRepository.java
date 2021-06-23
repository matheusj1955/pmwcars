package br.untinis.pmwcars.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.pmwcars.application.JPAUtil;
import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.model.Cliente;
import br.unitins.pmwcars.model.PessoaFisica;

public class ClienteRepository extends Repository<Cliente> {
	
	public ClienteRepository() {
		super(JPAUtil.getEntityManager());
	}
	
	public ClienteRepository(EntityManager em) {
		super(em);
	}
	
	public Cliente findByLogin(String login, String senha) throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" u ");
		jpql.append("FROM ");
		jpql.append(" Cliente u ");
		jpql.append("WHERE ");
		jpql.append(" u.usuario.login = :login ");
		jpql.append(" AND u.usuario.senha = :senha ");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		
		Cliente cliente = null;
		try {
			cliente = (Cliente) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cliente;
	}
	
	public Cliente findByPessoaFisica(PessoaFisica pessoaFisica) throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" p ");
		jpql.append("FROM ");
		jpql.append(" Cliente p ");
		jpql.append("WHERE ");
		jpql.append(" p.pessoaFisica.id = :id ");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("id", pessoaFisica.getId());
		
		Cliente cliente = null;
		try {
			cliente = (Cliente) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cliente;
	}
	
	public List<Cliente> findByNome(String nome) throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" p ");
		jpql.append("FROM ");
		jpql.append(" Cliente p ");
		jpql.append("WHERE ");
		jpql.append(" UPPER(p.pessoaFisica.nome) LIKE UPPER(:nome) ");
		jpql.append("ORDER BY p.pessoaFisica.nome ");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("nome", "%" + nome + "%");
		
		return query.getResultList();
	}
	
	public List<Cliente> findAll() throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" p ");
		jpql.append("FROM ");
		jpql.append(" Cliente p ");
		jpql.append("ORDER BY p.pessoaFisica.nome ");
		
		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
		 
	}
	
}