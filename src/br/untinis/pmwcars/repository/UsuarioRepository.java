package br.untinis.pmwcars.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.pmwcars.application.JPAUtil;
import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.model.DefaultEntity;
import br.unitins.pmwcars.model.Usuario;

public class UsuarioRepository extends Repository<Usuario> {

	public UsuarioRepository() {
		super(JPAUtil.getEntityManager());
	}
	
	public UsuarioRepository(EntityManager em) {
		super(em);
	}
	
	public List<Usuario> findAll() throws RepositoryException{ 
		
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("SELECT u FROM Usuario u ORDER BY u.nome ");
			
			return query.getResultList();
		} catch (Exception e) {
			System.out.println("Erro ao realizar uma consulta ao banco.");
			e.printStackTrace();
			throw new RepositoryException("Erro ao realizar uma consulta ao banco.");
		}
		
	}
	
	public Usuario findUsuario(String login, String senha) throws RepositoryException{ 
		
		try {
			EntityManager em = JPAUtil.getEntityManager();
			
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append("  u ");
			jpql.append("FROM ");
			jpql.append("  Usuario u ");
			jpql.append("WHERE ");
			jpql.append("  u.login = :login ");
			jpql.append("  AND u.senha = :senha ");
			
			Query query = em.createQuery(jpql.toString());
			query.setParameter("login", login);
			query.setParameter("senha", senha);
			
			return (Usuario) query.getSingleResult();
			
		} catch (Exception e) {
			System.out.println("Erro ao realizar uma consulta ao banco.");
			e.printStackTrace();
			return null;
		}
		
	}
}
