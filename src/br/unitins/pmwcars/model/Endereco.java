package br.unitins.pmwcars.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Endereco extends DefaultEntity<Endereco> {
	
	private static final long serialVersionUID = 4051882264263606320L;
	private String cep;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	
	@ManyToOne
	@JoinColumn(name="idcidade", nullable = false)
	private Cidade cidade;
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	
	

}
