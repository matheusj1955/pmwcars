package br.unitins.pmwcars.model;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Estado extends DefaultEntity<Estado> {

	private static final long serialVersionUID = 8236630558450224166L;

		private String nome;
		private String sigla;

		
//		@OneToMany(fetch = FetchType.LAZY)
//		private List<Cidade> listaCidade;
//		
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getSigla() {
			return sigla;
		}

		public void setSigla(String sigla) {
			this.sigla = sigla;
		}

}
