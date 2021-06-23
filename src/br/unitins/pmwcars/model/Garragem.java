package br.unitins.pmwcars.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Garragem extends DefaultEntity<Garragem>{
	
	private static final long serialVersionUID = 5224836876589954887L;
	private String nome;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="idcarro", nullable = false)
//	private Carro carro;
	
	private Integer quantidade;
//	private Double precoCompra;

	
	
//	public void setCarro(Carro carro) {
//	this.carro = carro;
//}	
//	public Carro getCarro() {
//		return carro;
//	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


}
