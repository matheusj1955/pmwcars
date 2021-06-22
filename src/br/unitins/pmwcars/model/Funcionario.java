package br.unitins.pmwcars.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Funcionario extends DefaultEntity<Funcionario> {
	

	private static final long serialVersionUID = -3041430973972680691L;

	private double salario;

	private Perfil perfil;

//	@OneToOne
//	@JoinColumn(unique = true, name="idusuario", nullable = false)
//	//@PrimaryKeyJoinColumn
//	private Usuario usuario;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "id_pessoafisica", unique = true)
	private PessoaFisica pessoaFisica;
	
//	@ManyToOne
//	@JoinColumn(name="idtipo", nullable = false)
//	private TipoFuncionario tipofuncionario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_municipio")
	private Municipio municipio;
	
	
	
	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + getId() + ", cpf=" + pessoaFisica.getCpf() + ", nome=" + pessoaFisica.getNome() + "]";
	}
	
}
