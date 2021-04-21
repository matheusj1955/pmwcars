package br.unitins.pmwcars.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cliente extends DefaultEntity<Cliente>{

	private static final long serialVersionUID = -7042528876951516024L;

	@OneToOne
	@JoinColumn(unique = true, name="idusuario", nullable = false)
	//@PrimaryKeyJoinColumn
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(unique = true, name="idpessoa", nullable = false)
	//@PrimaryKeyJoinColumn
	private Pessoa pessoa;
	
	@OneToMany(mappedBy = "cliente")
	private List<ItemVenda> listaitem;

	
}
