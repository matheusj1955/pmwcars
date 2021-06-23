package br.unitins.pmwcars.model;

import java.time.LocalDateTime;
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
	
	private String ano;

	private Modelo modelo;
	
	private String imagem;

	private Integer estoque;

	@ManyToOne(fetch = FetchType.LAZY)
	private Marca marca;

//	@OneToMany (fetch = FetchType.EAGER)
//	@JoinTable(name="Cars_Garragem",
//			joinColumns={@JoinColumn(name = "id_paciente", unique=false)},
//			inverseJoinColumns={@JoinColumn(name = "id_precaucao", unique=false)})
//	private List<Precaucao> precaucao;
	

	public String getNome() {
		return nome;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
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

	@Override
	public String toString() {
		return "Carro [nome=" + nome + ", valor=" + valor + ", ano=" + ano + ", modelo=" + modelo + ", imagem=" + imagem
				+ ", estoque=" + estoque + ", marca=" + marca + "]";
	}

	public String getImagem() {
		return imagem;
	}


	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	
	

//	@ManyToOne
//	@JoinColumn(name="idmodelo", nullable = false)
//	private Modelo modelo;
	

//	@JoinColumn(name="idmarca", nullable = false)
	
//	@ManyToOne
//	@JoinColumn(name="idstatus", nullable = false)
//	private Status status;


}
