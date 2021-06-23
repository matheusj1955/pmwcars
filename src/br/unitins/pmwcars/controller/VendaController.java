package br.unitins.pmwcars.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.pmwcars.application.FlashStorage;
import br.unitins.pmwcars.application.Session;
import br.unitins.pmwcars.application.Util;
import br.unitins.pmwcars.model.Carro;
import br.unitins.pmwcars.model.Usuario;
import br.unitins.pmwcars.model.Venda;
import br.untinis.pmwcars.repository.CarroRepository;

@Named
@ViewScoped
public class VendaController extends Controller<Venda>{
	
//	private List<Carro> listaCarro;

	private static final long serialVersionUID = -2928520673913298340L;

	@Override
	public Venda getEntity() {
		if (entity == null) {
			entity = new Venda();
		}
		return entity;
	}
	
	public VendaController() {
		Object obj = FlashStorage.getItemAndKeep("carroSelecionado");
		if(obj instanceof Carro) getEntity().setCarro((Carro) obj);
	}	
	
	public void compraFinalizada() {
		Usuario usuarioLogado = (Usuario) Session.getItem("usuarioLogado");
	    try {
	      CarroRepository cr = new CarroRepository();
	      getEntity().setUsuario(new Usuario());
	      System.out.println(usuarioLogado);
	      super.salvar();
	      Carro c = getEntity().getCarro();
	      c.setEstoque(c.getEstoque() - 1);
	      cr.save(c);
//	      Util.redirect("/Pmwcars/pages/finalizado.xhtml");
	    } catch (Exception e) {
	      e.printStackTrace();
	      Util.addInfoWarnMessage("Houve um erro ao processar a requisição");
	    }
	}
}
