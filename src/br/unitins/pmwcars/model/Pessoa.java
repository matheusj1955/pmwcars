package br.unitins.pmwcars.model;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Pessoa extends DefaultEntity<Pessoa> {
	
	private static final long serialVersionUID = -3680524947926074024L;

	private String nome;
	
	private LocalDate dataNascimento;

	private String email;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
