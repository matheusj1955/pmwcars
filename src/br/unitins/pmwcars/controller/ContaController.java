package br.unitins.pmwcars.controller;


import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.unitins.pmwcars.application.Session;
import br.unitins.pmwcars.application.Util;
import br.unitins.pmwcars.model.Usuario;

@Named
@RequestScoped
public class ContaController extends Controller<Usuario> {

	private static final long serialVersionUID = -7101833868629617785L;
	private Usuario usuarioLogado;

	public Usuario getclienteLogado() {
		if (usuarioLogado == null) // buscando o cliente da sessao
			usuarioLogado = (Usuario) Session.getInstance().getAttribute("usuarioLogado");
		return usuarioLogado;
	}

	@Override
	public Usuario getEntity() {
		// TODO Auto-generated method stub
		return getclienteLogado();
	}

	@Override
	public void salvar() {
		if (getEntity().getCodigoSeguranca() == null) {
			getEntity().setSenha(Util.hashSHA256(getEntity().getSenha()));
			super.salvar();
			return;
		}

		getEntity().setSenha(Util.hashSHA256(getEntity().getSenha()));
		getEntity().setCodigoSeguranca(Util.hashSHA256(getEntity().getCodigoSeguranca()));
		super.salvar();
	}

}