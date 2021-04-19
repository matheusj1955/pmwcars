package br.unitins.pmwcars.model;

import javax.persistence.Entity;

@Entity
public class Funcionario extends DefaultEntity<Funcionario> {
	

	private static final long serialVersionUID = -3041430973972680691L;

	private double salario;

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
