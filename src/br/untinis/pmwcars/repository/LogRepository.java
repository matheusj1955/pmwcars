package br.untinis.pmwcars.repository;

import javax.persistence.EntityManager;

import br.unitins.pmwcars.application.JPAUtil;
import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.model.Usuario;

public class LogRepository {

private EntityManager entityManager = null;
	
	public LogRepository() {
		EntityManager em = JPAUtil.getEntityManager();
	}
	
	public void save(Usuario usuario) throws RepositoryException {
		
	}
	
	public void remove(Usuario usuario) throws RepositoryException {
	}
	

	public EntityManager getEntityManager() {
		return entityManager;
	}

}
