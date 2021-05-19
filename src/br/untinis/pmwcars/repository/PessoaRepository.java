package br.untinis.pmwcars.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.pmwcars.application.JPAUtil;
import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.model.Pessoa;

public class PessoaRepository extends Repository<Pessoa> {
		
		public PessoaRepository() {
			super(JPAUtil.getEntityManager());
		}
		
		public PessoaRepository(EntityManager em) {
			super(em);
		}
		
//		public Pessoa findByPessoaFisica(PessoaFisica pessoaFisica) throws RepositoryException {
		public Pessoa findByPessoa(Pessoa pessoa) throws RepositoryException {

			EntityManager em = getEntityManager();
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append(" u ");
			jpql.append("FROM ");
			jpql.append(" Pessoa u ");
			jpql.append("WHERE ");
			jpql.append(" u.pessoa.id = :id ");
			
			Query query = em.createQuery(jpql.toString());
			query.setParameter("id", pessoa.getId());
			
			Pessoa p = null;
			try {
				p = (Pessoa) query.getSingleResult();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return p;
		}
		
		public List<Pessoa> findAll() throws RepositoryException {
			EntityManager em = getEntityManager();
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append(" u ");
			jpql.append("FROM ");
			jpql.append(" Pessoa u ");
			jpql.append("ORDER BY u.pessoa.nome ");
			
			Query query = em.createQuery(jpql.toString());
			return query.getResultList();
		}
		
	
}
