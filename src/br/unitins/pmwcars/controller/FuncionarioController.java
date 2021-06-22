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
import br.unitins.pmwcars.application.Security;
import br.unitins.pmwcars.application.Util;
import br.unitins.pmwcars.controller.listing.PessoaFisicaListing;
import br.unitins.pmwcars.model.Estado;
import br.unitins.pmwcars.model.Funcionario;
import br.unitins.pmwcars.model.Municipio;
import br.unitins.pmwcars.model.Perfil;
import br.unitins.pmwcars.model.PessoaFisica;
import br.untinis.pmwcars.repository.EstadoRepository;
import br.untinis.pmwcars.repository.FuncionarioRepository;
import br.untinis.pmwcars.repository.MunicipioRepository;
import br.untinis.pmwcars.repository.PessoaFisicaRepository;

@Named
@ViewScoped
public class FuncionarioController extends Controller<Funcionario> {
	
	private static final long serialVersionUID = 1067992066000332854L;
	
	private List<Municipio> listaMunicipio = null;
	
	private Estado estado = null;
	
	private List<Estado> listaEstado = null;
	
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

	@Override
	public void limpar() {
		super.limpar();
		estado = null;
		listaEstado = null;
		listaMunicipio = null;
	}

	public Perfil[] getListaPerfil() {
		return Perfil.values();
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