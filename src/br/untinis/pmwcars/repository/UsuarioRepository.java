package br.untinis.pmwcars.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.pmwcars.application.JPAUtil;
import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.model.Usuario;

public class UsuarioRepository {

	public void save(Usuario usuario) throws RepositoryException {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			
			em.getTransaction().begin();
			
			// insert or update
			em.merge(usuario);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao executar o método Save do Repository");
			throw new RepositoryException("Erro ao Salvar");
		}
		
	}
	
	public void remove(Usuario usuario) throws RepositoryException {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			
			em.getTransaction().begin();
			
			// insert or update
			em.remove(usuario);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Erro ao executar o método Remove do Repository");
			throw new RepositoryException("Erro ao Remover");
		}
	}
	
	public List<Usuario> findAll() throws RepositoryException {
		EntityManager em = JPAUtil.getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" p ");
		jpql.append("FROM ");
		jpql.append(" Usuario p ");
		jpql.append("ORDER BY p.nome ");
		
		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
		 
	}

	public Usuario findId(Usuario usuario) throws RepositoryException {
		EntityManager em = JPAUtil.getEntityManager();
		return em.find(usuario.getClass(), usuario.getId());
	}

}
