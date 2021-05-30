package br.unitins.pmwcars.model;



public enum Perfil {

	GERENTE(1, "Gerente"), 
	CLIENTE(2, "Cliente"), // precisa?
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
	
	@SuppressWarnings("unused")
	public static Perfil valueOf(Integer id) {
		if (id == null)
			return null;
		
		for (Perfil perfil : Perfil.values()) {
			if (perfil.id == id)
				return perfil;
		} 
		
		return null;

	}

}
