package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;
	//Atributos de la clase Reserva 
	
	private LocalDate diaEntrada; 
	private LocalDate diaSalida; 
	private int noches; 
	private int numeroReserva; 
	private ArrayList <Pago> listPagos;
	private Habitacion habitacion;
	
	//Constructor de la clase 
	
	public Reserva(LocalDate diaEntrada, LocalDate diaSalida, int noches, int numeroReserva, Habitacion habitacion) {
		super();
		this.diaEntrada = diaEntrada;
		this.diaSalida = diaSalida;
		this.noches = noches;
		this.numeroReserva = numeroReserva;
		this.habitacion = habitacion;
		this.listPagos = new ArrayList<Pago>();
	}

	public Reserva(){
		super();
	}
	

	//Getters & setters

	public LocalDate getDiaEntrada() {
		return diaEntrada;
	}

	public void setDiaEntrada(LocalDate diaEntrada) {
		this.diaEntrada = diaEntrada;
	}

	public LocalDate getDiaSalida() {
		return diaSalida;
	}

	public void setDiaSalida(LocalDate diaSalida) {
		this.diaSalida = diaSalida;
	}

	public int getNoches() {
		return noches;
	}

	public void setNoches(int noches) {
		this.noches = noches;
	}

	public int getNumeroReserva() {
		return numeroReserva;
	}

	public void setNumeroReserva(int numeroReserva) {
		this.numeroReserva = numeroReserva;
	}

	public ArrayList<Pago> getListPagos() {
		return listPagos;
	}

	public void setListPagos(ArrayList<Pago> listPagos) {
		this.listPagos = listPagos;
	}
	
	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	
	//Metodo hash & equals


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numeroReserva;
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
		Reserva other = (Reserva) obj;
		if (numeroReserva != other.numeroReserva)
			return false;
		return true;
	}
	
	
	
	
	
	
}
