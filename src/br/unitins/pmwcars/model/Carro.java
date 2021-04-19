package br.unitins.pmwcars.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Carro extends DefaultEntity<Carro> {
	
	private static final long serialVersionUID = 8136736208998816649L;

	private String nome;
	
	private double valor;
	
	private Date ano;

//	private  ano;

	@ManyToOne
	private Estado estado;
	
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getAno() {
		return ano;
	}

	public void setAno(Date ano) {
		this.ano = ano;
	}


	
//	private Date senha;

}
