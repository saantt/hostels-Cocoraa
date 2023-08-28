package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import exceptions.ClienteException;
import exceptions.ReservaException;
import persistencia.Persistencia;

public class Hotel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//Atributos de la clase hotel 
	
	private String nombre; 
	private String direccion; 
	private ArrayList<Persona> listPersona; 
	private ArrayList<Reserva> listReservas; 
	private ArrayList<Habitacion> listHabitaciones;
	
	//Constructor de la clase
	public Hotel(String nombre, String direccion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.listPersona = new ArrayList<Persona>();
		this.listReservas = new ArrayList<Reserva>();
		this.listHabitaciones = new ArrayList<Habitacion>();
	} 
	
	public Hotel(){
		super();
	}
	
	//Getters & setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public ArrayList<Persona> getListPersona() {
		return listPersona;
	}

	public void setListPersona(ArrayList<Persona> listPersona) {
		this.listPersona = listPersona;
	}

	public ArrayList<Reserva> getListReservas() {
		return listReservas;
	}

	public void setListReservas(ArrayList<Reserva> listReservas) {
		this.listReservas = listReservas;
	}

	public ArrayList<Habitacion> getListHabitaciones() {
		return listHabitaciones;
	}

	public void setListHabitaciones(ArrayList<Habitacion> listHabitaciones) {
		this.listHabitaciones = listHabitaciones;
	}
	
	//Metodo hash & equals

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Hotel other = (Hotel) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	//Metodo que verifica en la lista de personas s� es valido el recepcionista (comparando documento
	// y contrase�a)
	public boolean verificarRecep(String documento, String contrasenia){
		for (Persona persona : listPersona) {
			if (persona instanceof Recepcionista) {
                Recepcionista recepcionista = (Recepcionista) persona;
                if(recepcionista.getCedula().equals(documento) && 
                		recepcionista.getContrasenia().equals(contrasenia)){
                	return true;
                }
			}
		}
		return false;
	}
	
	public void actualizarEstado(LocalDate fecha, int numeroHabitacion) {
        for (Habitacion habitacion : listHabitaciones) {
        	if(habitacion.getNumeroHabitacion()== numeroHabitacion && habitacion.getReserva()!=null){
        		if (fecha.isAfter(habitacion.getReserva().getDiaEntrada().minusDays(1)) && 
                        fecha.isBefore(habitacion.getReserva().getDiaSalida().plusDays(1))) {
                        habitacion.setSituacion(SituacionActual.RESERVADA);
                    } else {
                        habitacion.setSituacion(SituacionActual.DISPONIBLE);
                    }
                } else {
                    habitacion.setSituacion(SituacionActual.DISPONIBLE);
                }
        }
    }

	//Metodo que retorna el ArrayList de todas las camas que tenga una habitacion
	public ArrayList<Cama> retornarCamas() {
		ArrayList<Cama> camas = new ArrayList<>();
		for (Habitacion habitacion : listHabitaciones) {
			if(habitacion.getListCamas()!=null){
			camas.addAll(habitacion.getListCamas());
			}
		}
		return camas;
	}

	//Metodo que actualiza el estado de las camas segun el tiempo de reserva de la habitacion 
	public void actualizarEstadoCama(LocalDate fecha, String nroCama) {
		for (Habitacion habitacion : listHabitaciones) {
			if(habitacion!= null && habitacion.getListCamas()!=null){
				for(Cama cama: habitacion.getListCamas()){
					if(habitacion.getReserva()!=null && cama.getNroCama().equals(nroCama)){
	        		if (fecha.isAfter(habitacion.getReserva().getDiaEntrada().minusDays(1)) && 
	                        fecha.isBefore(habitacion.getReserva().getDiaSalida().plusDays(1))) {
	                        cama.setSituacionCama(SituacionActual.RESERVADA);
	                    } else {
	                        cama.setSituacionCama(SituacionActual.DISPONIBLE);
	                }
			}
				}
			}
		}
		
	}

	//Metodo que devuelve el numero de habitacion en el que se encuentra una cama (segun su numero)
	public String devolverNroH(String nroCama) {
		String nroH ="";
		for (Habitacion habitacion : listHabitaciones) {
			if(habitacion!= null && habitacion.getListCamas()!=null){
				for(Cama cama: habitacion.getListCamas()){
					if(cama.getNroCama().equals(nroCama)){
						nroH= Integer.toString(habitacion.getNumeroHabitacion());
					}
				}
			}
		}
		return nroH;
	}

	//Metodo que devuelve con contadores cuantas habitaciones dobles estan reservadas y disponibles segun
	//los d�as de reservas
	public String devolverDisponibilidad(LocalDate fecha) {
		int habitacionesReservadas = 0;
	    int habitacionesDisponibles = 0;

	    for (Habitacion habitacion : listHabitaciones) {
	        if (habitacion.getTipoHabitacion().equals(Tipo.DOBLE) &&
	        		habitacion.getReserva() != null) {
	            if (fecha.isAfter(habitacion.getReserva().getDiaEntrada().minusDays(1)) && 
	                fecha.isBefore(habitacion.getReserva().getDiaSalida().plusDays(1))) {
	                habitacionesReservadas++;
	            }
	        } else {
	            habitacionesDisponibles++;
	        }
	    }
	    String resultado = habitacionesReservadas+" reservadas y "+habitacionesDisponibles+
	    		" disponibles";
	    return resultado;
	}
	
	//Metodo que devuelve con contadores cuantas habitaciones individuales estan reservadas y 
	//disponibles segun los d�as de reservas
	public String devolverDisponibilidadI(LocalDate fecha) {
		int habitacionesReservadas = 0;
	    int habitacionesDisponibles = 0;

	    for (Habitacion habitacion : listHabitaciones) {
	        if (habitacion.getTipoHabitacion().equals(Tipo.INDIVIDUAL) &&
	        		habitacion.getReserva() != null) {
	            if (fecha.isAfter(habitacion.getReserva().getDiaEntrada().minusDays(1)) && 
	                fecha.isBefore(habitacion.getReserva().getDiaSalida().plusDays(1))) {
	                habitacionesReservadas++;
	            }
	        } else {
	            habitacionesDisponibles++;
	        }
	    }
	    String resultado = habitacionesReservadas+" reservadas y "+habitacionesDisponibles+
	    		" disponibles";
	    return resultado;
	}
	
	//Metodo que devuelve con contadores cuantas camas dobles estan reservadas y disponibles segun
		//los d�as de reservas
	public String devolverDisponibilidadCamasD(LocalDate fecha) {
		int camasReservadas = 0;
	    int camasDisponibles = 0;

	    for (Habitacion habitacion : listHabitaciones) {
	        if (habitacion.getListCamas()!= null &&
	        		habitacion.getReserva() != null) {
	        	for(Cama cama: habitacion.getListCamas()){
	            if (cama.getTipoCama().equals(Tipo.DOBLE) && fecha.isAfter(habitacion.getReserva().getDiaEntrada().minusDays(1)) && 
	                fecha.isBefore(habitacion.getReserva().getDiaSalida().plusDays(1))) {
	                camasReservadas++;
	            }
	        	}
	        } else {
	            camasDisponibles++;
	        }
	    }
	    String resultado = camasReservadas+" reservadas y "+camasDisponibles+
	    		" disponibles";
	    return resultado;
	}
	
	//Metodo que devuelve con contadores cuantas habitaciones individuales estan reservadas y disponibles segun
	//los d�as de reservas
	public String devolverDisponibilidadCamasI(LocalDate fecha) {
		int camasReservadas = 0;
	    int camasDisponibles = 0;

	    for (Habitacion habitacion : listHabitaciones) {
	        if (habitacion.getListCamas()!= null &&
	        		habitacion.getReserva() != null) {
	        	for(Cama cama: habitacion.getListCamas()){
	            if (cama.getTipoCama().equals(Tipo.INDIVIDUAL) && fecha.isAfter(habitacion.getReserva().getDiaEntrada().minusDays(1)) && 
	                fecha.isBefore(habitacion.getReserva().getDiaSalida().plusDays(1))) {
	                camasReservadas++;
	            }
	        	}
	        } else {
	            camasDisponibles++;
	        }
	    }
	    String resultado = camasReservadas+" reservadas y "+camasDisponibles+
	    		" disponibles";
	    return resultado;
	}

	//Metodo que verifica si una habitacion esta disponible en el rango de fecha
	//entre la fechaInicio y fechaSalida de reserva
	public ArrayList<Integer> verificarHabitacion(LocalDate fechaInicio, LocalDate fechaSalida) {
		ArrayList <Integer> habitaciones = new ArrayList<>();
		for (Habitacion habitacion : listHabitaciones) {
				Reserva reserva= habitacion.getReserva();
		        // Si la habitaci�n no tiene reserva, est� disponible
		        if (reserva == null) {
		            habitaciones.add(habitacion.getNumeroHabitacion());
		        }
		        if(reserva!=null){
		        LocalDate diaReservaEntrada = reserva.getDiaEntrada();
		        LocalDate diaReservaSalida = reserva.getDiaSalida();

		        // Si la fecha de entrada solicitada es despu�s de la fecha de salida de la reserva, est� disponible
		        if (fechaInicio.isAfter(diaReservaSalida)) {
		            habitaciones.add(habitacion.getNumeroHabitacion());
		        }

		        // Si la fecha de salida solicitada es antes de la fecha de entrada de la reserva, est� disponible
		        if (fechaSalida.isBefore(diaReservaEntrada)) {
		        	habitaciones.add(habitacion.getNumeroHabitacion());
		        }

		        // Si las fechas de entrada y salida solicitadas est�n dentro del rango de la reserva, no est� disponible
		        if ((fechaInicio.isEqual(diaReservaEntrada) || fechaInicio.isAfter(diaReservaEntrada)) &&
		            (fechaSalida.isEqual(diaReservaSalida) || fechaSalida.isBefore(diaReservaSalida))) {
		            continue;
		        }

		        // Si la habitaci�n no est� reservada durante todo el rango, est� disponible
		        if (fechaInicio.isBefore(diaReservaEntrada) && fechaSalida.isAfter(diaReservaSalida)) {
		        	habitaciones.add(habitacion.getNumeroHabitacion());
		        }
		    }
		}
		return habitaciones;
	}
	
	//Metodo que crea las reservas
	public Reserva crearReserva(LocalDate fechaInicio, LocalDate fechaSalida, int numeroReserva, String habitacion) throws ReservaException {
		Reserva reserva = new Reserva();
		reserva.setDiaEntrada(fechaInicio);
		reserva.setDiaSalida(fechaSalida);
		reserva.setNumeroReserva(numeroReserva);
		reserva.setHabitacion(reconocerHabitacion(habitacion));
		if(existeReserva(numeroReserva) == true){
			throw new ReservaException("Ya se realizo una reserva");
		}
		listReservas.add(reserva);
		actualizarDatos(habitacion,numeroReserva);
		System.out.println(listReservas);
		System.out.println(listPersona);
		return reserva;
	}

	//Metodo de ayuda para a�adir una habitaci�n en la creaci�n de la reserva
	private Habitacion reconocerHabitacion(String habitacion1) {
		for (Habitacion habitacion : listHabitaciones) {
			if(habitacion.getNumeroHabitacion()== Integer.parseInt(habitacion1)){
				habitacion.setSituacion(SituacionActual.RESERVADA);
				return habitacion;
			}
		}
		return null;
	}
	
	//Procedimiento de ayuda que a�ade la reserva a la habitacion, ya que tienen una
	//asociacion bidireccional
	private void actualizarDatos(String habitacion1, int numeroReserva){
		for (Habitacion habitacion : listHabitaciones) {
			if(habitacion.getNumeroHabitacion()== Integer.parseInt(habitacion1)){
				for (Reserva reserva : listReservas) {
					if(reserva.getNumeroReserva()==numeroReserva){
						habitacion.setReserva(reserva);
					}
				}
			}
		}
	}

	//Metodo que verifica si ya existe una reserva
	private boolean existeReserva(int numeroReserva) {
		Optional<Reserva> findFirst = listReservas.stream().
				filter(x -> x.getNumeroReserva()==(numeroReserva)).findFirst();
		return findFirst.isPresent();
	}

	//Metodo que devuelve el n�mero de camas que tiene una habitaci�n
	public int devolverCamas(String habitacion) {
		for (Habitacion habitacion1 : listHabitaciones) {
			if(habitacion1.getNumeroHabitacion()==Integer.parseInt(habitacion) && 
					habitacion1.getListCamas()!=null){
				return habitacion1.getListCamas().size();
			}
		}
		return 0;
	}

	//Metodo que calcula el valor total de una habitaci�n
	public int calcularPagoReserva(String selectedState) {
		int precio= 0;
		if(selectedState.equals("Habitacion individual+extra")){
			precio= 190000;
		}
		if(selectedState.equals("Habitacion individual")){
			precio= 150000;
		}
		if(selectedState.equals("Habitacion doble+extra")){
			precio= 340000 ;
		}
		if(selectedState.equals("Habitacion doble")){
			precio= 300000;
		}
		return precio;
	}

	//Metodo que crea los clientes
	public Cliente crearCliente(String nombre2, String cedula, Reserva reserva) throws ClienteException {
		Cliente cliente = new Cliente();
		cliente.setNombre(nombre2);
		cliente.setCedula(cedula);
		if(cliente.getListReservas()!=null){
			cliente.getListReservas().add(reserva);
		}
		if(existeCliente(cedula) == true){
			throw new ClienteException("El cliente ya existe dentro del registro del hotel");
		}
		listPersona.add(cliente);
		return cliente;
	}

	//Metodo que verifica si ya existe un cliente
	private boolean existeCliente(String cedula) {
		Optional<Persona> findFirst = listPersona.stream().
				filter(x -> x.getCedula().equals(cedula)).findFirst();
		return findFirst.isPresent();
	}

	//Metodo logico que ayuda en el momento de buscar un cliente (Recepcionista)
	public boolean obtenerInfo(String nombre2) {
		for (Persona persona: listPersona) {
			if (persona instanceof Cliente) {
                Cliente cliente = (Cliente) persona;
                if(cliente.getNombre().equals(nombre2)){
                	return true;
                }
			}
		}
		return false;
	}

	//Metodo que regitra un cliente desde la vista del recepcionista
	public Cliente registrarCliente(String nombre2, String documento, String telefono, String correo) throws ClienteException {
		Cliente cliente = new Cliente();
		cliente.setNombre(nombre2);
		cliente.setCedula(documento);
		cliente.setTelefono(documento);
		cliente.setCorreo(correo);
		
		if(existeCliente(documento) == true){
			throw new ClienteException("El cliente ya existe dentro del registro del hotel");
		}
		listPersona.add(cliente);
		return cliente;
	}
     
		
	

}
