package br.unitins.pmwcars.controller;

import javax.faces.context.FacesContext;

import javax.faces.view.ViewScoped;
import javax.inject.Named;


import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.application.Util;
import br.unitins.pmwcars.model.PessoaFisica;
import br.unitins.pmwcars.model.RecuperarSenha;
import br.unitins.pmwcars.model.Usuario;
import br.untinis.pmwcars.repository.RecuperarSenhaRepository;
import br.untinis.pmwcars.repository.UsuarioRepository;

import java.time.LocalDateTime;

@Named
@ViewScoped
public class TrocarSenhaController extends Controller<RecuperarSenha> {

	private static final long serialVersionUID = 493416054223982546L;
	private String codigo = null;
	private String senha = null;

	@Override
	public RecuperarSenha getEntity() {
		if (entity == null)
			entity = new RecuperarSenha();
		return entity;
	}

	public void trocaSenha() {
		UsuarioRepository usr = new UsuarioRepository();
		RecuperarSenhaRepository recu = new RecuperarSenhaRepository();

		try {
			System.out.println(codigo);
			RecuperarSenha rs = recu.findByCodigo(getCodigo());
			Usuario us = rs.getUsuario(); 
			us.setSenha(senha);
			usr.save(us);	
			Util.addInfoMessage("Sua senha foi Alterada!");
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}

	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	
}
