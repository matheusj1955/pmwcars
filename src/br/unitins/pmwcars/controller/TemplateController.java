package br.unitins.pmwcars.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.pmwcars.application.Session;
import br.unitins.pmwcars.application.Util;
import br.unitins.pmwcars.model.Usuario;

@Named
@ViewScoped
public class TemplateController implements Serializable {

	private static final long serialVersionUID = -4840557863183170428L;

	public void perfilUsuario() {
//		Object obj = Session.getInstance().getAttribute("usuarioLogado");
//		if (obj == null)
//			return null;
//		return (Usuario) obj;

//		Session.getInstance().invalidateSession();
		Util.redirect("/Pmwcars/pages/editarusuario.xhtml");
//		System.out.println(id usuario);

//eu to pensando em fazer a pagina de perfil, ao inves de criar uma pg redirecionar para a pg de usuario passando o cpf pra q seja pesquisado a pessoa
	}

	public void encerrarSessao() {
		Session.getInstance().invalidateSession();
		Util.redirect("login.xhtml");
	}
	
	public Usuario getUsuarioLogado() {
		Object obj = Session.getInstance().getAttribute("usuarioLogado");
		if (obj == null)
			return null;
		return (Usuario) obj;
	}
}
