package br.unitins.pmwcars.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.controller.listing.EstadoListing;
import br.unitins.pmwcars.model.Estado;
import br.unitins.pmwcars.model.Funcionario;
import br.unitins.pmwcars.model.Marca;
import br.unitins.pmwcars.model.Municipio;
import br.unitins.pmwcars.model.PessoaFisica;
import br.untinis.pmwcars.repository.EstadoRepository;
import br.untinis.pmwcars.repository.FuncionarioRepository;
import br.untinis.pmwcars.repository.MunicipioRepository;
import br.untinis.pmwcars.repository.PessoaFisicaRepository;


@Named
@ViewScoped
public class MunicipioController extends Controller<Municipio> {
	
	private static final long serialVersionUID = -4065144337144616278L;

	@Override
	public Municipio getEntity() {
		if (entity == null) {
			entity = new Municipio();
	      entity.setEstado(new Estado());
		}
		return entity;
	}
	
	@Override
	public void limpar() {
		super.limpar();
	}
	
	public void abrirEstadoListing() {
	EstadoListing listing = new EstadoListing();
	listing.open();
	}

	public void obterEstadoListing(SelectEvent<Estado> event) {
		getEntity().setEstado(event.getObject());
	}
	
}

//	

//	
//	@Override
//	public void limpar() {
//		super.limpar();
//	}
//	
//	public void abrirEstadoListing() {
//		EstadoListing listing = new EstadoListing();
//		listing.open();
//	}
//	
//	public void obterEstadoListing(SelectEvent<Estado> event) {
//		getEntity().setEstado(event.getObject());
//		
//		MunicipioRepository repo = new MunicipioRepository();
//		try {
//			Municipio m = repo.findByEstadoM(getEntity().getEstado());
//			if (m != null) {
//				setEntity(repo.findByEstadoM(getEntity().getEstado()));
//			}
//		} catch (RepositoryException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void buscarPessoaFisica() {
//		EstadoRepository repo = new EstadoRepository();
//		MunicipioRepository repoMunicipio = new MunicipioRepository();
//		try {
//			Estado es = repo.findById(getEntity().getEstado().getId());
//			if (es != null) {
//				Municipio m = repoMunicipio.findByEstadoM(es);
//				if (m != null)
//					setEntity(m);
//				else
//					getEntity().setEstado(es);
//			}
//		} catch (RepositoryException e) {
//			e.printStackTrace();
//		}
//		
//		
//	}
//}
