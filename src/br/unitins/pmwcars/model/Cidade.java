package br.unitins.pmwcars.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cidade extends DefaultEntity<Cidade> {

	private static final long serialVersionUID = 6456244649145092439L;
	private String nome;
	private String sigla;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idestado", nullable = false)
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}
