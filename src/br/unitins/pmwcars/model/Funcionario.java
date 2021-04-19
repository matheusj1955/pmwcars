package br.unitins.pmwcars.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Funcionario extends DefaultEntity<Funcionario> {
	

	private static final long serialVersionUID = -3041430973972680691L;

	private double salario;

	@ManyToOne
	@JoinColumn(name="idtelefone", nullable = false)
	private Telefone telefone;
	
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
