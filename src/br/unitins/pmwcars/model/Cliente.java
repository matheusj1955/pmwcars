package br.unitins.pmwcars.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cliente extends DefaultEntity<Cliente>{

	private static final long serialVersionUID = -7042528876951516024L;

	@OneToOne
	@JoinColumn(unique = true, name="idusuario", nullable = false)
	//@PrimaryKeyJoinColumn
	private Usuario usuario;
	
	
	@OneToMany(mappedBy = "cliente")
	private List<ItemVenda> listaitem;

	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "id_pessoafisica", unique = true)
	private PessoaFisica pessoaFisica;

//	@ManyToOne
//	private Estado estado;

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

//	public Estado getEstado() {
//		return estado;
//	}
//
//	public void setEstado(Estado estado) {
//		this.estado = estado;
//	}

	@Override
	public String toString() {
		return "Paciente [id=" + getId() + ", cpf=" + pessoaFisica.getCpf() + ", nome=" + pessoaFisica.getNome() + "]";
	}

	
}
