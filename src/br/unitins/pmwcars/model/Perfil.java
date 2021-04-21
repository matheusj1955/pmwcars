package br.unitins.pmwcars.model;

import java.util.ArrayList;
import java.util.List;

public enum Perfil {

	GERENTE(1, "Gerente"), 
	CLIENTE(2, "Cliente"), 
	OPERACIONAL(3, "Operacional");
	
	private int id;
	private String label;
	
	Perfil(int id, String label) {
		this.id = id;
		this.label = label;
			
	}
	
	public int getId() {
		return id;
	}
	
	public String getLabel() {
		return label;
	}
	
	public static Perfil valueOf(Integer id) {
		if (id == null)
			return null;
		
		for (Perfil dep : Perfil.values()) {
			if (dep.getId() == id)
				return dep;
		}
		return null;
	}	
}
