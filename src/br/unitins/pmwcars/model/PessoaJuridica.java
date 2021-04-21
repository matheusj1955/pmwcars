package br.unitins.pmwcars.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PessoaJuridica extends Pessoa {

	private static final long serialVersionUID = -560721635329738843L;
	private String cnpj;
	
//	@OneToOne
//	@JoinColumn(unique = true, name="idpessoa", nullable = false)
//	private Pessoa pessoa;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	

}
