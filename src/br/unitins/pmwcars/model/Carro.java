package br.unitins.pmwcars.model;

import java.util.Date;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Carro extends DefaultEntity<Carro> {
	
	private static final long serialVersionUID = 8136736208998816649L;

	private String nome;
	
	private double valor;
	
	private Date ano;

	private Modelo modelo;

	@OneToMany(fetch = FetchType.LAZY)
	private List<ItemVenda> listaitemvenda;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Marca marca;


	@OneToMany(fetch = FetchType.LAZY)
	private List<Garragem> garragem;
	

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

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	

//	@ManyToOne
//	@JoinColumn(name="idmodelo", nullable = false)
//	private Modelo modelo;
	

//	@JoinColumn(name="idmarca", nullable = false)
	
//	@ManyToOne
//	@JoinColumn(name="idstatus", nullable = false)
//	private Status status;


}
