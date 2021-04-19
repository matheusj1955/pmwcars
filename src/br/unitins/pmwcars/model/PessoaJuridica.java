package br.unitins.pmwcars.model;

import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends DefaultEntity<PessoaJuridica> {

	private static final long serialVersionUID = -560721635329738843L;
	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	

}
