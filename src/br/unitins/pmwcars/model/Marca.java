package br.unitins.pmwcars.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Marca  extends DefaultEntity<Marca>{

//	marca igual estado
	
	private static final long serialVersionUID = 5630456718670379495L;
	private String nome;
	
	@OneToMany(mappedBy = "marca")
	private List<Carro> listacarro;

	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
