package br.untinis.pmwcars.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.pmwcars.application.JPAUtil;
import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.model.Funcionario;
import br.unitins.pmwcars.model.PessoaFisica;

public class FuncionarioRepository extends Repository<Funcionario> {

	public FuncionarioRepository() {
		super(JPAUtil.getEntityManager());
	}
	
	public FuncionarioRepository(EntityManager em) {
		super(em);
	}

	public Funcionario findByPessoaFisica(PessoaFisica pessoaFisica) throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" p ");
		jpql.append("FROM ");
		jpql.append(" Funcionario p ");
		jpql.append("WHERE ");
		jpql.append(" p.pessoaFisica.id = :id ");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("id", pessoaFisica.getId());
		
		Funcionario funcionario = null;
		try {
			funcionario = (Funcionario) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return funcionario;
	}
	
	public List<Funcionario> findByNome(String nome) throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" p ");
		jpql.append("FROM ");
		jpql.append(" Funcionario p ");
		jpql.append("WHERE ");
		jpql.append(" UPPER(p.pessoaFisica.nome) LIKE UPPER(:nome) ");
		jpql.append("ORDER BY p.pessoaFisica.nome ");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("nome", "%" + nome + "%");
		
		return query.getResultList();
	}
	
	public List<Funcionario> findAll() throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" p ");
		jpql.append("FROM ");
		jpql.append(" Funcionario p ");
		jpql.append("ORDER BY p.pessoaFisica.nome ");
		
		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
		 
	}
}
