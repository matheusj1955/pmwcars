package br.unitins.pmwcars.controller;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Formatter;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.pmwcars.application.Email;
import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.application.Util;
import br.unitins.pmwcars.model.RecuperarSenha;
import br.unitins.pmwcars.model.Usuario;
import br.untinis.pmwcars.repository.Repository;
import br.untinis.pmwcars.repository.UsuarioRepository;


@Named
@ViewScoped
public class EsqueceuSenhaController extends Controller<RecuperarSenha> {
	private static final long serialVersionUID = 8893135762115295270L;
	
	private String email;

	@Override
	public RecuperarSenha getEntity() {
		if (entity == null) {
			entity = new RecuperarSenha();
		}
		return entity;
	}
	
	public void enviar() {
		UsuarioRepository repo = new UsuarioRepository();
		Usuario usuario = null;
		try {
			usuario = repo.findByEmail(getEmail());
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		
		if (usuario == null) {
			Util.addErrorMessage("N�o foi encontrado esse email no sistema.");
			return;
		}
		
		double valor1 = Math.random() * 100;
		double valor2 = Math.random() * 100;
		
		DecimalFormat format = new DecimalFormat("000");
		String codigo = format.format(valor1)+"-"+format.format(valor2);
		
		Email email = new Email(getEmail(), "Esqueceu Senha", "Informe o seguinte c�digo: "+codigo);
		getEntity().setCodigo(codigo);
		getEntity().setUsuario(usuario);
		// gerando a data com 24 horas a mais
		LocalDateTime dataLimite = LocalDateTime.now();
		getEntity().setDataLimite(dataLimite.plusDays(1));
		getEntity().setUtilizado(false);
		
		
		if (salvarNovo()) {
			if (email.enviar() ) {
				Util.redirect("recuperarsenha.xhtml");
			} else {
				Util.addErrorMessage("Problemas ao enviar o c�digo por email.");
			}
		} else {
			Util.addErrorMessage("Problemas ao salvar no banco. Tente novamente mais tarde.");
		}

	}
	
	public boolean salvarNovo() {
		Repository<RecuperarSenha> repo = new Repository<RecuperarSenha>();
	
		try {
			repo.beginTransaction();
			repo.save(getEntity());
			repo.commitTransaction();
			
			limpar();
			return true;
		} catch (RepositoryException e) {
			repo.rollbackTransaction();
			return false;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}