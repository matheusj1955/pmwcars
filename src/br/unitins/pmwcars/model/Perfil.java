package br.unitins.pmwcars.model;

import java.util.ArrayList;
import java.util.List;

public enum Perfil {

	CLIENTE(1, "Cliente"), ADMINISTRADOR(2, "Administrador"), FUNCIONARIO(3, "Funcionario");

	private int id;
	private String label;
	private List<String> paginasComPermissao;

	Perfil(int id, String label) {
		this.id = id;
		this.label = label;
		
		paginasComPermissao = new ArrayList<String>();
			

		paginasComPermissao.add("/Pmwcars/usuario.xhtml");
		paginasComPermissao.add("/Pmwcars/usuariolisting.xhtml");
		paginasComPermissao.add("/Pmwcars/contato.xhtml");
		paginasComPermissao.add("/Pmwcars/index.xhtml");
		
		if(id == 1) {
			paginasComPermissao.add("/Pmwcars/pages/listacarros.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/item.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/finalizado.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/cliente.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/venda.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/pessoafisica.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/pessoafisicalisting.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/editarusuario.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/img-usuario");
}


		if (id == 2) {
			paginasComPermissao.add("/Pmwcars/pages/funcionario.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/funcionariolisting.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/pessoafisica.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/pessoafisicalisting.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/estado.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/estadolisting.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/usuariolisting.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/editarusuario.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/carro.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/carrolisting.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/municipio.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/municipiolisting.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/img-usuario");

			
			paginasComPermissao.add("/Pmwcars/pages/listacarros.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/item.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/finalizado.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/cliente.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/venda.xhtml");
			
		}
		
		if (id == 3) {
			paginasComPermissao.add("/Pmwcars/pages/carro.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/carrolisting.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/editarusuario.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/municipio.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/municipiolisting.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/estado.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/estadolisting.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/img-usuario");

			
			paginasComPermissao.add("/Pmwcars/pages/listacarros.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/item.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/finalizado.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/cliente.xhtml");
			paginasComPermissao.add("/Pmwcars/pages/venda.xhtml");
		}

	}

	public int getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public List<String> getPaginasComPermissao() {
		return paginasComPermissao;
	}

	@SuppressWarnings("unused")
	public static Perfil valueOf(Integer id) {
		if (id == null)
			return null;

		for (Perfil perfil : Perfil.values()) {
			if (perfil.id == id)
				return perfil;
		}

		return null;

	}

}
