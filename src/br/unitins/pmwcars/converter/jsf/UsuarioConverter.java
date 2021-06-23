package br.unitins.pmwcars.converter.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.unitins.pmwcars.application.RepositoryException;
import br.unitins.pmwcars.model.Usuario;
import br.untinis.pmwcars.repository.UsuarioRepository;

@FacesConverter(forClass = Usuario.class)

public class UsuarioConverter implements Converter<Usuario> {

	@Override
	public Usuario getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty())
			return null;
		
		UsuarioRepository repo = new UsuarioRepository();
		Usuario usuario;
		try {
			usuario = repo.findById(Integer.valueOf(value.trim()));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		} catch (RepositoryException e) {
			e.printStackTrace();
			return null;
		}
		return usuario;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Usuario value) {
		if (value == null || value.getId() == null)
			return null;
		return value.getId().toString();
	}

}
