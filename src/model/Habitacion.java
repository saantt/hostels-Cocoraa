package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Habitacion implements Serializable {
	private static final long serialVersionUID = 1L;
	//Atributos de la clase habitacion 
	
	private int numeroHabitacion; 
	private int valorHabitacion; 
	private ArrayList <Cama> listCamas;
	private Estado estadoHabitacion;
	private Tipo tipoHabitacion; 
	private SituacionActual situacion;
	private Reserva reserva;

	
	//Constructor de la clase
	
	public Habitacion(int numeroHabitacion, int valorHabitacion,Estado estadoHabitacion,
			Tipo tipoHabitacion, SituacionActual situacion, Reserva reserva) {
		super();
		this.numeroHabitacion = numeroHabitacion;
		this.valorHabitacion = valorHabitacion;
		this.listCamas = new ArrayList<Cama>();
		this.estadoHabitacion = estadoHabitacion;
		this.tipoHabitacion = tipoHabitacion;
		this.situacion = situacion;
		this.reserva = reserva;
	}
	
	public Habitacion(){
		super();
	}
	
	//Getters & Setters

	public int getNumeroHabitacion() {
		return numeroHabitacion;
	}

	public void setNumeroHabitacion(int numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}

	public int getValorHabitacion() {
		return valorHabitacion;
	}

	public void setValorHabitacion(int valorHabitacion) {
		this.valorHabitacion = valorHabitacion;
	}

	public ArrayList<Cama> getListCamas() {
		return listCamas;
	}

	public void setListCamas(ArrayList<Cama> listCamas) {
		this.listCamas = listCamas;
	}

	public Estado getEstadoHabitacion() {
		return estadoHabitacion;
	}

	public void setEstadoHabitacion(Estado estadoHabitacion) {
		this.estadoHabitacion = estadoHabitacion;
	}

	public Tipo getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(Tipo tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public SituacionActual getSituacion() {
		return situacion;
	}

	public void setSituacion(SituacionActual situacion) {
		this.situacion = situacion;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	//Metodo hash & equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numeroHabitacion;
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
		Habitacion other = (Habitacion) obj;
		if (numeroHabitacion != other.numeroHabitacion)
			return false;
		return true;
	}
	
	
	
	
	
	
	

}
