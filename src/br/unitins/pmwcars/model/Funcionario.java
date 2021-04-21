package br.unitins.pmwcars.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Funcionario extends DefaultEntity<Funcionario> {
	

	private static final long serialVersionUID = -3041430973972680691L;

	private double salario;

	@OneToOne
	@JoinColumn(unique = true, name="idusuario", nullable = false)
	//@PrimaryKeyJoinColumn
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(unique = true, name="idpessoafisica", nullable = false)
	//@PrimaryKeyJoinColumn
	private PessoaFisica pessoaFisica;
	
//	@ManyToOne
//	@JoinColumn(name="idtipo", nullable = false)
//	private TipoFuncionario tipofuncionario;
	
	
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

}
