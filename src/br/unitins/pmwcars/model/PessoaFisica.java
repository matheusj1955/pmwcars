package br.unitins.pmwcars.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PessoaFisica extends Pessoa{

	private static final long serialVersionUID = -4448115550699240435L;
	private String cpf;
	
//	@OneToOne
//	@JoinColumn(unique = true, name="idpessoa", nullable = false)
//	private Pessoa pessoa;
	

	//é necessario essa ligação com funcionario?
//	@OneToOne(mappedBy = "funcionario")
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
