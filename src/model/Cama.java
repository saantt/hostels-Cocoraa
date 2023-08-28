package model;

import java.io.Serializable;

public class Cama implements Serializable {

	private static final long serialVersionUID = 1L;
	//Atributos de la clase cama 
	
	private String nroCama;
	private int valorCama;
	private Tipo tipoCama;
	private Estado estadoCama;
	private SituacionActual situacionCama;
	
	//Constructor de la clase cama
	
	public Cama(boolean disponibilidad, int valorCama, Tipo tipoCama, Estado estadoCama, 
			String nroCama, SituacionActual situacionCama) {
		super();
		this.valorCama = valorCama;
		this.tipoCama = tipoCama;
		this.estadoCama = estadoCama;
		this.nroCama = nroCama;
		this.situacionCama = situacionCama;
	}
	
	public Cama(){
		super();
	}
	
	//Getters & setters 
	
	
	public int getValorCama() {
		return valorCama;
	}

	public SituacionActual getSituacionCama() {
		return situacionCama;
	}

	public void setSituacionCama(SituacionActual situacionCama) {
		this.situacionCama = situacionCama;
	}

	public void setValorCama(int valorCama) {
		this.valorCama = valorCama;
	}

	public Tipo getTipoCama() {
		return tipoCama;
	}

	public void setTipoCama(Tipo tipoCama) {
		this.tipoCama = tipoCama;
	}

	public Estado getEstadoCama() {
		return estadoCama;
	}

	public void setEstadoCama(Estado estadoCama) {
		this.estadoCama = estadoCama;
	}
	
	public String getNroCama() {
		return nroCama;
	}

	public void setNroCama(String nroCama) {
		this.nroCama = nroCama;
	}

	
	//Metodo hash & equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nroCama == null) ? 0 : nroCama.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cama other = (Cama) obj;
		if (nroCama == null) {
			if (other.nroCama != null)
				return false;
		} else if (!nroCama.equals(other.nroCama))
			return false;
		return true;
	}
	


	
	
	
	
	

}
