package model;

import java.io.Serializable;

public class Recepcionista extends Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//Atributos de la clase recepcionista
	
	private String contrasenia;

	//Contructor de la clase
	public Recepcionista(String nombre, String cedula, String telefono, String correo, String contrasenia) {
		super(nombre, cedula, telefono, correo);
		this.contrasenia = contrasenia;
	} 
	
	public Recepcionista(){
		super();
	}

	//Get & set 
	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	//Metodo hash & equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((contrasenia == null) ? 0 : contrasenia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recepcionista other = (Recepcionista) obj;
		if (contrasenia == null) {
			if (other.contrasenia != null)
				return false;
		} else if (!contrasenia.equals(other.contrasenia))
			return false;
		return true;
	}

	
	
	

}
