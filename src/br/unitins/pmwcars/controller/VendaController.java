package br.unitins.pmwcars.controller;

import java.util.List;

import br.unitins.pmwcars.model.Carro;
import br.unitins.pmwcars.model.Venda;

public class VendaController extends Controller<Venda>{

	
	private List<Carro> listaCarro;
	
	@Override
	public Venda getEntity() {
		if (entity == null) {
			entity = new Venda();
		}
		return entity;
	}
	
	
	
//	public void addCarrinho(Midia midia) {
//		try {
//			MidiaDAO dao = new MidiaDAO();
//			// obtendo os dados atuais da midia
//			midia = dao.obterUm(midia);
//			
//			List<ItemVenda> listaItemVenda = null;
//			Object obj = Session.getInstance().getAttribute("carrinho");
//			
//			if (obj == null) 
//				listaItemVenda = new ArrayList<ItemVenda>();
//			else 
//				listaItemVenda = (List<ItemVenda>) obj;
//			
//			// montando o item de venda
//			ItemVenda item = new ItemVenda();
//			item.setMidia(midia);
//			item.setPreco(midia.getPreco());
//			listaItemVenda.add(item);
//			
//			// atualizando a sessao do carrinho de compras
//			Session.getInstance().setAttribute("carrinho", listaItemVenda);
//			
//			Util.addInfoMessage("O produto: " + midia.getNome() + " foi adicionado ao carrinho.");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			Util.addErrorMessage("Problema ao adicionar o produto ao carrinho. Tente novamente.");
//		}
//	}
}
