package br.untinis.pmwcars.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.pmwcars.application.JPAUtil;
import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.model.Estado;
import br.unitins.pmwcars.model.Carro;

public class CarroRepository extends Repository<Carro> {

	public CarroRepository() {
		super(JPAUtil.getEntityManager());
	}
	
	public CarroRepository(EntityManager em) {
		super(em);
	}
	
	public List<Carro> findByNome(String nome) throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" p ");
		jpql.append("FROM ");
		jpql.append(" Carro p ");
		jpql.append("WHERE ");
		jpql.append(" UPPER(p.nome) LIKE UPPER(:nome) ");
		jpql.append("ORDER BY p.nome ");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("nome", "%" + nome + "%");
		
		return query.getResultList();
	}
	
	public List<Carro> findAll() throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" p ");
		jpql.append("FROM ");
		jpql.append(" Carro p ");
		jpql.append("ORDER BY p.nome ");
		
		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
		 
	}
	
}
