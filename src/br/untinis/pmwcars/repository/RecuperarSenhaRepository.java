package br.untinis.pmwcars.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.pmwcars.application.JPAUtil;
import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.model.RecuperarSenha;

public class RecuperarSenhaRepository extends Repository<RecuperarSenha> {

	public RecuperarSenhaRepository() {
		super(JPAUtil.getEntityManager());
	}
	
	
	public RecuperarSenhaRepository(EntityManager em) {
		super(em);
	}
	
	public RecuperarSenha findByCodigo(String codigo) throws RepositoryException {
		try {
			EntityManager em = getEntityManager();
			
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append(" u ");
			jpql.append("FROM ");
			jpql.append(" RecuperarSenha u ");
			jpql.append("WHERE ");
			jpql.append(" u.recuperarSenha.codigo = :codigo");
			Query query = em.createQuery(jpql.toString());
			query.setParameter("codigo",  codigo);

			return (RecuperarSenha)(query.getSingleResult());
		} catch (Exception e) {
			System.out.println("Erro ao realizar uma consulta ao banco.");
			e.printStackTrace();
			throw new RepositoryException("Erro ao realizar uma consulta ao banco.");
		}
	}	
}