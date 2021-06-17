package br.unitins.pmwcars.model;

public enum Modelo {

//	@OneToMany(fetch = FetchType.LAZY)
//	private List<Carro> listacarro;

	SEDAN(1, "Sedan"), 
	HATCH(2, "Hatch"),
	PICAPE(3, "Picape"),
	CAMINHONETE(4, "Caminhonete"),
	SUV(4, "Suv");

	private int id;
	private String label;
	
	Modelo(int id, String label) {
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
	public static Modelo valueOf(Integer id) {
		if (id == null)
			return null;
		
		for (Modelo modelo : Modelo.values()) {
			if (modelo.id == id)
				return modelo;
		} 
		
		return null;

	}

}
