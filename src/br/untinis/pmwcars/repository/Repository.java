package br.untinis.pmwcars.repository;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.unitins.pmwcars.application.JPAUtil;
import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.model.DefaultEntity;

public class Repository<T extends DefaultEntity<T>> {

	protected EntityManager entityManager = null;

	public Repository(EntityManager em) {
		super();
		entityManager = em;
	}
	
	public Repository() {
		super();
		entityManager = JPAUtil.getEntityManager();
	}

	public void beginTransaction() throws RepositoryException {
		try {
			getEntityManager().getTransaction().begin();
		} catch (Exception e) {
			System.out.println("Problemas ao iniciar uma transa��o.");
			e.printStackTrace();
			throw new RepositoryException("Erro ao iniciar o acesso ao banco de dados.");
		}
	}

	public void commitTransaction() throws RepositoryException {
		try {
			getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Problemas ao concluir a transa��o (Commit).");
			e.printStackTrace();
			throw new RepositoryException("Erro ao concluir a opera��o no banco de dados.");
		}
	}

	public void rollbackTransaction() {
		try {
			getEntityManager().getTransaction().rollback();
		} catch (Exception e) {
			System.out.println("Problemas ao concluir uma transa��o (Rollback).");
			e.printStackTrace();
		}
	}

	public void save(T t) throws RepositoryException {
		try {
			EntityManager em = getEntityManager();
			em.merge(t);
			
		} catch (Exception e) {
			System.out.println("Erro ao executar o m�todo Save do Repository");
			throw new RepositoryException("Erro ao Salvar");
		}
		
	}

	public void remove(T t) throws RepositoryException {
		try {
			EntityManager em = getEntityManager();
			T obj = em.merge(t);
			em.remove(obj);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao executar o m�todo Remove do Repository");
			throw new RepositoryException("Erro ao Remover");
		}
	}

	public T findById(int id) throws RepositoryException {
		try {
			// obtendo o tipo da classe de forma generica (a classe deve ser publica)
			final ParameterizedType type = 	(ParameterizedType) getClass().getGenericSuperclass();
			Class<T> tClass = (Class<T>) (type).getActualTypeArguments()[0];
			
			T t = (T) getEntityManager().find(tClass, id);
			return t;
		} catch (Exception e) {
			System.out.println("Erro ao executar o m�todo find do Repository");
			e.printStackTrace();
			throw new RepositoryException("Erro ao buscar os dados");
		}
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

}