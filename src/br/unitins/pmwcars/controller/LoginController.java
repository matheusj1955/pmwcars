package br.unitins.pmwcars.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.unitins.pmwcars.application.Security;
import br.unitins.pmwcars.application.SessionStorage;
import br.unitins.pmwcars.application.Util;
import br.unitins.pmwcars.model.Cliente;
import br.unitins.pmwcars.model.Funcionario;
import br.unitins.pmwcars.model.Usuario;
import br.untinis.pmwcars.repository.ClienteRepository;
import br.untinis.pmwcars.repository.FuncionarioRepository;

@Named
@RequestScoped
public class LoginController {

	private Usuario usuario;

	public void logar() { //cliente
		
		ClienteRepository dao = new ClienteRepository();
		try {
			Cliente clienteLogado = dao.findByLogin(getUsuario().getLogin(), Security.hash(getUsuario()));

			System.out.println(clienteLogado);
			if (clienteLogado == null)
				Util.addErrorMessage("Usuário ou senha inválido.");
			else {
				// Usuario existe com as credenciais
				System.out.println("LOGADO");
				SessionStorage.setItem("usuarioLogado", clienteLogado);
				Util.redirect("/Pmwcars/index.xhtml");
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			Util.addErrorMessage("Problema ao verificar o Login. Entre em contato pelo email: contato@email.com.br");
		}
	}
	
		public void logarFuncionario() {
		
			FuncionarioRepository dao = new FuncionarioRepository();
			try {
				Funcionario funcionarioLogado = dao.findByLogin(getUsuario().getLogin(), Security.hash(getUsuario()));

				System.out.println(funcionarioLogado);
				if (funcionarioLogado == null)
					Util.addErrorMessage("Usuário ou senha inválido.");
				else {
					// Usuario existe com as credenciais
					System.out.println("LOGADO");
					SessionStorage.setItem("usuarioLogado", funcionarioLogado);
					Util.redirect("/Pmwcars/index.xhtml");
				}
					
			} catch (Exception e) {
				e.printStackTrace();
				Util.addErrorMessage("Problema ao verificar o Login. Entre em contato pelo email: contato@email.com.br");
			}
		}
		
		
	public void criarCliente() {
		Util.redirect("/Pmwcars/cliente.xhtml");
	}
	
	public void criarFuncionario() {
		Util.redirect("/Pmwcars/funcionario.xhtml");
	}
	
	public void esqueceuSenha() {
		Util.redirect("/Pmwcars/esqueceusenha.xhtml");
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