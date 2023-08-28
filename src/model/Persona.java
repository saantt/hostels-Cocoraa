package model;

import java.io.Serializable;

public abstract class Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	//Atributos de la clase persona 
	
	private String nombre; 
	private String cedula; 
	private String telefono;
	private String correo;
	
	//Constructor de la clase
	public Persona(String nombre, String cedula, String telefono, String correo) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.telefono = telefono;
		this.correo = correo;
	} 
	
	public Persona(){
		super();
	}
	
	//Getters & setters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	//Metodo hash & equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
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
		Persona other = (Persona) obj;
		if (cedula == null) {
			if (other.cedula != null)
				return false;
		} else if (!cedula.equals(other.cedula))
			return false;
		return true;
	}
	
	
	
	

}
