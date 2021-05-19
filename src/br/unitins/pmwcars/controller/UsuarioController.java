package br.unitins.pmwcars.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.pmwcars.model.Perfil;
import br.unitins.pmwcars.model.Usuario;


@Named
@ViewScoped
public class UsuarioController extends Controller<Usuario> {

	private static final long serialVersionUID = 8086276094345653703L;
	
	@Override
	public Usuario getEntity() {
		if (entity == null)
			entity = new Usuario();
		return entity;
	}
	
	public Perfil[] getListaPerfil() {
		return Perfil.values();
	}

}