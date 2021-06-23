package br.unitins.pmwcars.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.pmwcars.application.FlashStorage;
import br.unitins.pmwcars.application.Util;
import br.unitins.pmwcars.model.Carro;
import br.unitins.pmwcars.model.Garragem;

@Named
@ViewScoped
public class ItemController  extends  Controller<Carro>{

	private static final long serialVersionUID = 821963763517168577L;

	@Override
	public Carro getEntity() {
		if (entity == null) {
			entity = new Carro();
		}
		return entity;
	}
	
	public ItemController() {
		Object obj = FlashStorage.getItemAndKeep("carroSelecionado");
		if(obj instanceof Carro) entity = (Carro) obj;
	}
	
	public void comprar() {
		
		FlashStorage.setItem("carroSelecionado", entity);
		Util.redirect("/Pmwcars/pages/venda.xhtml");
	}
}
