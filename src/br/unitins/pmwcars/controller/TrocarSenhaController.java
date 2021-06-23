package br.unitins.pmwcars.controller;

import javax.faces.context.FacesContext;

import javax.faces.view.ViewScoped;
import javax.inject.Named;


import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.application.Security;
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
	private String email = null;
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
			RecuperarSenha pr = recu.findByCodigo(getSenha());
			if (!pr.getUsuario().getLogin().equals(email)) {
				Util.addErrorMessage("O codigo invalido");
				return;
			}
			if (pr.isUtilizado()) {
				Util.addErrorMessage("Codigo invadilo, gere um novo codigo");
				return;
			}
			if (pr.getDataCadastro().plusDays(1).isBefore(LocalDateTime.now())) {
				Util.addErrorMessage("Seu tempo expirou, gere um novo codigo");
				return;
			}
			pr.getUsuario().setSenha(getSenha());
			pr.setUsuario(Security.encript(pr.getUsuario()));
			System.out.println(pr.getUsuario());

			usr.beginTransaction();
			recu.beginTransaction();

			usr.save(pr.getUsuario());
			pr.setUtilizado(true);
			recu.save(pr);

			usr.commitTransaction();
			recu.commitTransaction();

			Util.addInfoMessage("Senha Alterada com sucesso");
			
		} catch (RepositoryException e) {
			e.printStackTrace();
		} finally {
			codigo = null;
			email = null;
			senha = null;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
