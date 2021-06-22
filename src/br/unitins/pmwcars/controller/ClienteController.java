package br.unitins.pmwcars.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.file.UploadedFile;

import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.application.Util;
import br.unitins.pmwcars.controller.listing.PessoaFisicaListing;
import br.unitins.pmwcars.model.Cliente;
import br.unitins.pmwcars.model.Estado;
import br.unitins.pmwcars.model.Municipio;
import br.unitins.pmwcars.model.PessoaFisica;
import br.untinis.pmwcars.repository.ClienteRepository;
import br.untinis.pmwcars.repository.EstadoRepository;
import br.untinis.pmwcars.repository.MunicipioRepository;
import br.untinis.pmwcars.repository.PessoaFisicaRepository;

@Named
@ViewScoped
public class ClienteController extends  Controller<Cliente> {
	
	private static final long serialVersionUID = 8814885295057959663L;

	private List<Municipio> listaMunicipio = null;
	
	private Estado estado = null;
	
	private List<Estado> listaEstado = null;
		
	@Override
	public Cliente getEntity() {
		if (entity == null) {
			entity = new Cliente();
			entity.setPessoaFisica(new PessoaFisica());
			entity.setMunicipio(new Municipio());
			entity.getMunicipio().setEstado(new Estado());
		}
		return entity;
	}
	
	@Override
	public void limpar() {
		super.limpar();
		estado = null;
		listaEstado = null;
		listaMunicipio = null;
	}

	
	public void buscarPessoaFisica() {
		PessoaFisicaRepository repo = new PessoaFisicaRepository();
		ClienteRepository repoCliente = new ClienteRepository();
		try {
			PessoaFisica pf = repo.findByCpf(getEntity().getPessoaFisica().getCpf());
			if (pf != null) {
				Cliente c = repoCliente.findByPessoaFisica(pf);
				if (c != null)
					setEntity(c);
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
		
		ClienteRepository repo = new ClienteRepository();
		try {
			Cliente c = repo.findByPessoaFisica(getEntity().getPessoaFisica());
			if (c != null) {
				setEntity(repo.findByPessoaFisica(getEntity().getPessoaFisica()));
			}
			setEstado(getEntity().getMunicipio().getEstado());
			filtrarMunicipios();
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
	
	public List<Estado> getListaEstado() { ///***********
		if (listaEstado == null) {
			EstadoRepository repo = new EstadoRepository();
			try {
				listaEstado =  repo.findAll();
			} catch (RepositoryException e) {
				listaEstado =  new ArrayList<Estado>();
			}
		}
		return listaEstado;
	}
	
	public List<Municipio> filtrarMunicipios() {
		MunicipioRepository repo = new MunicipioRepository();
		try {
			listaMunicipio =  repo.findByEstado(getEstado().getId());
		} catch (RepositoryException e) {
			listaMunicipio =  new ArrayList<Municipio>();
		}
		return listaMunicipio;
	}
	
	public List<Municipio> getListaMunicipio() {
		if (listaMunicipio == null) {
			listaMunicipio =  new ArrayList<Municipio>();
		}
		return listaMunicipio;
	}

	public Estado getEstado() {
		if (estado == null)
			estado = new Estado();
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	private InputStream fotoInputStream = null;
	private String nomeFoto = null;
	
	public InputStream getFotoInputStream() {
		return fotoInputStream;
	}

	public void setFotoInputStream(InputStream fotoInputStream) {
		this.fotoInputStream = fotoInputStream;
	}

	public String getNomeFoto() {
		if (nomeFoto == null)
			nomeFoto = "Selecione uma foto...";
		return nomeFoto;
	}
	
	public void upload(FileUploadEvent event) {
		System.out.println("Entrou");
		UploadedFile uploadFile = event.getFile();
		System.out.println("nome arquivo: " + uploadFile.getFileName());
		System.out.println("tipo: " + uploadFile.getContentType());
		System.out.println("tamanho: " + uploadFile.getSize());

		if (uploadFile.getContentType().equals("image/png")) {
			try {
				fotoInputStream = uploadFile.getInputStream();
				nomeFoto = uploadFile.getFileName();
				System.out.println("inputStream: " + uploadFile.getInputStream().toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Util.addInfoMessage("Upload realizado com sucesso.");
		} else {
			Util.addErrorMessage("O tipo da image deve ser png.");
		}

	}
	
	public void salvar() {
		if (! Util.saveImageUsuario(fotoInputStream, "png", getEntity().getId())) {
			Util.addErrorMessage("Erro ao salvar. Não foi possível salvar a imagem do usuário.");
			return;
		}
		// salvando no banco
		super.salvar();
	}
	
}