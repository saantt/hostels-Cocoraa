package model;

import java.io.Serializable;

public class Pago implements Serializable {
	private static final long serialVersionUID = 1L;
	//Atributos de la clase pago
	
	private int valorReserva; 
	private String numeroPago;
	private TipoPago tipoPago;
	
	//Constructor de la clase 
	
	public Pago(int valorReserva, String numeroPago, TipoPago tipoPago) {
		super();
		this.valorReserva = valorReserva;
		this.numeroPago = numeroPago;
		this.tipoPago = tipoPago;
	}
	
	public Pago(){
		super();
	}
	
	//Getters & setters

	public int getValorReserva() {
		return valorReserva;
	}

	public void setValorReserva(int valorReserva) {
		this.valorReserva = valorReserva;
	}

	public String getNumeroPago() {
		return numeroPago;
	}

	public void setNumeroPago(String numeroPago) {
		this.numeroPago = numeroPago;
	}

	public TipoPago getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}
	
	//Metodo hash & equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroPago == null) ? 0 : numeroPago.hashCode());
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
		Pago other = (Pago) obj;
		if (numeroPago == null) {
			if (other.numeroPago != null)
				return false;
		} else if (!numeroPago.equals(other.numeroPago))
			return false;
		return true;
	}
	
	
	
	
	
	

}
