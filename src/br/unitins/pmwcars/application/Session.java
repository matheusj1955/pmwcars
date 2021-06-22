	package br.unitins.pmwcars.application;

import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class Session {
	
	private static Session session = null;
	
	private Session() {}
	
	public static Session getInstance() {
		if (session == null)
			session = new Session();
		return session;
	}
	

	private static Map<String, Object> getSessionMap() {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		if (ec == null) {
			throw new RuntimeException("Este recurso eh para ser utilizado apenas em aplicacoes WEB.");
		}
		
		return ec.getSessionMap();
	}
	
	public static Object getItem(String key) {
		return getSessionMap().get(key);
	}
	
	
	
	private ExternalContext getExternalContext() {
		if (FacesContext.getCurrentInstance().getExternalContext() == null) {
			throw new RuntimeException("Este recurso eh para ser utilizado apenas em aplicacoes WEB.");
		}
		return FacesContext.getCurrentInstance().getExternalContext();
	}
	
	public Object getAttribute(String key) {
		return getExternalContext().getSessionMap().get(key);
	}
	

	
	public void setAttribute(String key, Object value) {
		getExternalContext().getSessionMap().put(key, value);
	}
	
	public void invalidateSession() {
		getExternalContext().invalidateSession();
	}

}