package br.unitins.pmwcars.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.pmwcars.application.Session;
import br.unitins.pmwcars.application.SessionStorage;
import br.unitins.pmwcars.application.Util;
import br.unitins.pmwcars.model.Cliente;
import br.unitins.pmwcars.model.Funcionario;
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

	}

	public void encerrarSessao() {
		Session.getInstance().invalidateSession();
		Util.redirect("/Pmwcars/login.xhtml");
	}
	
	public Usuario getUsuarioLogado() {
		Object obj = SessionStorage.getItem("usuarioLogado");
		if (obj == null)
			return null;
		if(obj instanceof Funcionario )
			return ((Funcionario) obj).getUsuario();
		if(obj instanceof Cliente )
			return ((Cliente) obj).getUsuario();
		return (Usuario) obj;
		
	}
	
	public boolean isFuncionario() {
		Object obj = SessionStorage.getItem("usuarioLogado");
		if(obj == null)
			return false;
		return (obj instanceof Funcionario);
	}
	
	public boolean isCliente() {
		Object obj = SessionStorage.getItem("usuarioLogado");
		if(obj == null)
			return false;
		return (obj instanceof Cliente);
	}
	
	public String getNomeUsuario() {
		Object obj = SessionStorage.getItem("usuarioLogado");
		if(isCliente())
			return ((Cliente) obj).getPessoaFisica().getNome();
		if(isFuncionario())
			return ((Funcionario) obj).getPessoaFisica().getNome();
		return null;
	}
}
