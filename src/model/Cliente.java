package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente extends Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	//Atributos de la clase cliente 
	
	private ArrayList<Reserva> listReservas;

	public Cliente(String nombre, String cedula, String telefono, String correo) {
		super(nombre, cedula, telefono, correo);
		this.listReservas = new ArrayList<Reserva>();
	}
	
	public Cliente(){
		super();
	}
	
	//Getters & setters
	
	public ArrayList<Reserva> getListReservas() {
		return listReservas;
	}

	public void setListReservas(ArrayList<Reserva> listReservas) {
		this.listReservas = listReservas;
	}
	
	
	
	
	
	
	
	

}
