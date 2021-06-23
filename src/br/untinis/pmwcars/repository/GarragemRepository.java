package br.untinis.pmwcars.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.pmwcars.application.JPAUtil;
import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.model.Garragem;

public class GarragemRepository extends Repository<Garragem> {

	
	public GarragemRepository() {
		super(JPAUtil.getEntityManager());
	}
	
	public GarragemRepository(EntityManager em) {
		super(em);
	}
	
	public List<Garragem> findByNome(String nome) throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" p ");
		jpql.append("FROM ");
		jpql.append(" Garragem p ");
		jpql.append("WHERE ");
		jpql.append(" UPPER(p.nome) LIKE UPPER(:nome) ");
		jpql.append("ORDER BY p.nome ");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("nome", "%" + nome + "%");
		
		return query.getResultList();
	}
	
	
	public List<Garragem> findAll() throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" p ");
		jpql.append("FROM ");
		jpql.append(" Garragem p ");
		jpql.append("ORDER BY p.nome ");
		
		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
		 
	}
	
	
	public List<Garragem> findCarroGarragem() throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  e ");
		jpql.append("FROM ");
		jpql.append("  Garragem e ");
		jpql.append("   JOIN FETCH e.carro ");

		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
	}
	
}

