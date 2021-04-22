package br.untinis.pmwcars.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.pmwcars.application.JPAUtil;
import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.model.Marca;

public class MarcaRepository extends Repository<Marca> {
	
	public MarcaRepository() {
		super(JPAUtil.getEntityManager());
	}
	
	public MarcaRepository(EntityManager em) {
		super(em);
	}
	
	public List<Marca> findByNome(String nome) throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" p ");
		jpql.append("FROM ");
		jpql.append(" Marca p ");
		jpql.append("WHERE ");
		jpql.append(" UPPER(p.nome) LIKE UPPER(:nome) ");
		jpql.append("ORDER BY p.nome ");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("nome", "%" + nome + "%");
		
		return query.getResultList();
	}
	
	public List<Marca> findAll() throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" p ");
		jpql.append("FROM ");
		jpql.append(" Marca p ");
		jpql.append("ORDER BY p.nome ");
		
		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
		 
	}
	
}