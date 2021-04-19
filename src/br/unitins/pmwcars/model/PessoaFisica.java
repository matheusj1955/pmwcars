package br.unitins.pmwcars.model;

import javax.persistence.Entity;

@Entity
public class PessoaFisica extends DefaultEntity<PessoaFisica> {

	private static final long serialVersionUID = -4448115550699240435L;
	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
