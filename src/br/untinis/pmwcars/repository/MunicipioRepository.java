package br.untinis.pmwcars.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.pmwcars.application.JPAUtil;
import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.model.Estado;
import br.unitins.pmwcars.model.Municipio;

public class MunicipioRepository extends Repository<Municipio> {
	
	public MunicipioRepository() {
		super(JPAUtil.getEntityManager());
	}
	
	public MunicipioRepository(EntityManager em) {
		super(em);
	}
	
	public List<Municipio> findByEstado(Integer id) throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" m ");
		jpql.append("FROM ");
		jpql.append(" Municipio m ");
		jpql.append("WHERE ");
		jpql.append(" m.estado.id = :id ");
		jpql.append("ORDER BY m.nome ");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("id", id);
		
		return query.getResultList();
	}
	
	public List<Municipio> findByNome(String nome) throws RepositoryException {
		return findByNome(nome, null);
	}
	
	public List<Municipio> findByNome(String nome, Integer maxResults) throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" m ");
		jpql.append("FROM ");
		jpql.append(" Municipio m ");
		jpql.append("WHERE ");
		jpql.append(" UPPER(m.nome) LIKE UPPER(:nome) ");
		jpql.append("ORDER BY m.nome ");
		
		Query query = em.createQuery(jpql.toString());
		query.setParameter("nome", "%" + nome + "%");
		
		if (maxResults != null)
			 query.setMaxResults(maxResults);
		
		return query.getResultList();
	}
	
	public List<Municipio> findAll() throws RepositoryException {
		EntityManager em = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" m ");
		jpql.append("FROM ");
		jpql.append(" Municipio m ");
		jpql.append("ORDER BY m.nome ");
		
		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
	}
	
}