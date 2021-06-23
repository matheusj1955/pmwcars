package br.unitins.pmwcars.controller;


import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.unitins.pmwcars.application.SessionStorage;
import br.unitins.pmwcars.application.Util;
import br.unitins.pmwcars.model.Funcionario;
import br.untinis.pmwcars.repository.FuncionarioRepository;

@Named
@RequestScoped
public class ContaFuncionarioController extends Controller<Funcionario> {


	private static final long serialVersionUID = -3402374086042765435L;

	public Funcionario getFuncionarioLogado() {
		if (entity == null) {
			FuncionarioRepository fr = new FuncionarioRepository();
			Funcionario f = (Funcionario) SessionStorage.getItem("usuarioLogado");
			try {
				entity = fr.findById(f.getId());
			} catch (Exception e) {
				// TODO: handle exception
				entity = new Funcionario();	
			}
		}
		System.out.println(entity);
		return entity;
	}

	@Override
	public Funcionario getEntity() {
		// TODO Auto-generated method stub
		return getFuncionarioLogado();
	}

	@Override
	public void salvar() {
		if (getEntity().getUsuario().getCodigoSeguranca() == null) {
			
			getEntity().getUsuario().setSenha(Util.hashSHA256(getEntity().getUsuario().getSenha()));
			super.salvar();
			return;
		}

		getEntity().getUsuario().setSenha(Util.hashSHA256(getEntity().getUsuario().getSenha()));
		getEntity().getUsuario().setCodigoSeguranca(Util.hashSHA256(getEntity().getUsuario().getCodigoSeguranca()));
		super.salvar();
	}

}
