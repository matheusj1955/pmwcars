package br.unitins.pmwcars.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.controller.listing.PessoaFisicaListing;
import br.unitins.pmwcars.model.Estado;
import br.unitins.pmwcars.model.Funcionario;
import br.unitins.pmwcars.model.Municipio;
import br.unitins.pmwcars.model.PessoaFisica;
import br.untinis.pmwcars.repository.FuncionarioRepository;
import br.untinis.pmwcars.repository.MunicipioRepository;
import br.untinis.pmwcars.repository.PessoaFisicaRepository;

@Named
@ViewScoped
public class FuncionarioController extends Controller<Funcionario> {
	
	private static final long serialVersionUID = 1067992066000332854L;

	@Override
	public Funcionario getEntity() {
		if (entity == null) {
			entity = new Funcionario();
			entity.setPessoaFisica(new PessoaFisica());
			entity.setMunicipio(new Municipio());
			entity.getMunicipio().setEstado(new Estado());
		}
		return entity;
	}
	
	public void buscarPessoaFisica() {
		PessoaFisicaRepository repo = new PessoaFisicaRepository();
		FuncionarioRepository repoFuncionario = new FuncionarioRepository();
		try {
			PessoaFisica pf = repo.findByCpf(getEntity().getPessoaFisica().getCpf());
			if (pf != null) {
				Funcionario p = repoFuncionario.findByPessoaFisica(pf);
				if (p != null)
					setEntity(p);
				else
					getEntity().setPessoaFisica(pf);
			}
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void abrirPessoaFisicaListing() {
		PessoaFisicaListing listing = new PessoaFisicaListing();
		listing.open();
	}
	
	public void obterPessoaFisicaListing(SelectEvent<PessoaFisica> event) {
		getEntity().setPessoaFisica(event.getObject());
		
		FuncionarioRepository repo = new FuncionarioRepository();
		try {
			Funcionario p = repo.findByPessoaFisica(getEntity().getPessoaFisica());
			if (p != null) {
				setEntity(repo.findByPessoaFisica(getEntity().getPessoaFisica()));
			}
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}
	
	public List<Municipio> completeMunicipio(String filtro) {
		MunicipioRepository repo = new MunicipioRepository();
		try {
			return repo.findByNome(filtro, 5);
		} catch (RepositoryException e) {
			e.printStackTrace();
			return new ArrayList<Municipio>();
		}
	}
	

}