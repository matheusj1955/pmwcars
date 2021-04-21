package br.unitins.pmwcars.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cidade extends DefaultEntity<Cidade> {

	private static final long serialVersionUID = 6456244649145092439L;
	private String nome;

	@ManyToOne
	@JoinColumn(name="idestado", nullable = false)
	private Estado estado;
	
	@OneToMany(mappedBy = "cidade")
	private List<Endereco> endereco;
	
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
}
