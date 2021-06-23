package br.unitins.pmwcars.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
////	@Column(nullable = false)
//	@Temporal(TemporalType.DATE)
	private LocalDateTime nascimento;

//	private String email;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDateTime nascimento) {
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
