package br.unitins.pmwcars.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.unitins.pmwcars.application.Session;
import br.unitins.pmwcars.application.Util;
import br.unitins.pmwcars.model.Usuario;
import br.untinis.pmwcars.repository.UsuarioRepository;

@Named
@RequestScoped
public class LoginController {

	private Usuario usuario;

	public void logar() {
		
		UsuarioRepository repo = new UsuarioRepository();
		try {
			Usuario usuarioLogado = 
					repo.findUsuario(getUsuario().getLogin(), getUsuario().getSenha());
			
			if (usuarioLogado == null)
				Util.addErrorMessage("Usuário ou senha inválido.");
			else {
				// Usuario existe com as credenciais
				System.out.println("LOGADO");
				Session.getInstance().setAttribute("usuarioLogado", usuarioLogado);
				Util.redirect("/Pmwcars/usuario.xhtml");
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			Util.addErrorMessage("Problema ao verificar o Login. Entre em contato pelo email: contato@email.com.br");
		}
	}

	public Usuario getUsuario() {
		if (usuario == null)
			usuario = new Usuario();
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}