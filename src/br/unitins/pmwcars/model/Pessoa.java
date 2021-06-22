package br.unitins.pmwcars.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa extends DefaultEntity<Pessoa> {
	
	private static final long serialVersionUID = -3680524947926074024L;

//	@OneToOne
//	@JoinColumn(unique = true, name="idendereco")
//	private Endereco Endereco;
//	unique = true, name="idendereco", nullable = false
	
	//	@OneToOne(mappedBy = "pessoa")
	
	
	private String nome;
	
	private Date nascimento;

//	private String email;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}



//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}


	
	
	
}
