	package br.unitins.pmwcars.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Garragem extends DefaultEntity<Garragem>{
	
	private static final long serialVersionUID = 5224836876589954887L;
	private String nome;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idcarro", nullable = false)
	private Carro carro;
	
	
	
	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


}
