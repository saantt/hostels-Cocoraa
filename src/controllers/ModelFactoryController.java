package controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import exceptions.ClienteException;
import exceptions.ReservaException;
import model.Cama;
import model.Cliente;
import model.Estado;
import model.Habitacion;
import model.Hotel;
import model.Persona;
import model.Recepcionista;
import model.Reserva;
import model.SituacionActual;
import model.Tipo;
import persistencia.Persistencia;

public class ModelFactoryController {

	Hotel hotel;

	// ------------------------------ Singleton
	// ------------------------------------------------
	// Clase estatica oculta. Tan solo se instanciara el singleton una vez
	private static class SingletonHolder {
		// El constructor de Singleton puede ser llamado desde aqu� al ser protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	// M�todo para obtener la instancia de nuestra clase
	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}

	public ModelFactoryController() {

		iniciarSalvarDatosPrueba();
		if (hotel == null) {
			cargarResourceXML();
		}
	}

	private void iniciarSalvarDatosPrueba() {

		inicializarDatos();

//		try {
////
////			Persistencia.guardarVendedores(getRed().getListaVendedores());
////			Persistencia.guardarAdministrador(getRed().getAdministrador());
////			Persistencia.guardarProductos(getRed().getListaVendedores());
////			
////			Persistencia.guardarRecursoBancoBinario(red);
////			Persistencia.guardarRecursoBancoXML(red);
////			
////			Persistencia.crearCopias();
//
//			//Persistencia.cargarDatosArchivos(getBanco());
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public void cargarResourceXML() {

		hotel = Persistencia.cargarRecursoBancoXML();
	}

	public void guardarResourceXML() {

		Persistencia.guardarRecursoBancoXML(hotel);
	}

//	public void CargarRecursoXML() {
//
//		Persistencia.cargarRecursoBancoXML();
//	}
//
//	public void guardarResourceXML() {
//
//		Persistencia.guardarRecursoBancoXML(hotel);
//	}

	// Inicializacion de los datos (quemados)

	private void inicializarDatos() {
		
//		cargarResourceXML();
		

		hotel = new Hotel("Hostels Cocora", "cra 230");

		ArrayList<Persona> listaPersonas = new ArrayList<>();

		Recepcionista recep = new Recepcionista();
		recep.setNombre("Juan");
		recep.setCedula("1234");
		recep.setTelefono("3154785697");
		recep.setCorreo("juan.gmail.com");
		recep.setContrasenia("000");

		listaPersonas.add(recep);

		ArrayList<Habitacion> listaHabitaciones = new ArrayList<>();

		ArrayList<Reserva> listaReservas = new ArrayList<>();

		ArrayList<Cama> listaCamas = new ArrayList<>();

		ArrayList<Cama> listaCamas2 = new ArrayList<>();

		Habitacion habitacion1 = new Habitacion();
		habitacion1.setNumeroHabitacion(101);
		habitacion1.setTipoHabitacion(Tipo.INDIVIDUAL);
		habitacion1.setEstadoHabitacion(Estado.EN_OPERACION);
		habitacion1.setValorHabitacion(300000);

		Habitacion habitacion2 = new Habitacion();
		habitacion2.setNumeroHabitacion(102);
		habitacion2.setTipoHabitacion(Tipo.DOBLE);
		habitacion2.setSituacion(SituacionActual.DISPONIBLE);
		habitacion2.setEstadoHabitacion(Estado.EN_OPERACION);
		habitacion2.setValorHabitacion(500000);

		Habitacion habitacion3 = new Habitacion();
		habitacion3.setNumeroHabitacion(103);
		habitacion3.setTipoHabitacion(Tipo.INDIVIDUAL);
		habitacion3.setSituacion(SituacionActual.DISPONIBLE);
		habitacion3.setEstadoHabitacion(Estado.EN_OPERACION);
		habitacion3.setValorHabitacion(500000);

		Reserva reserva1 = new Reserva();
		reserva1.setDiaEntrada(LocalDate.of(2023, 8, 27));
		reserva1.setDiaSalida(LocalDate.of(2023, 8, 30));
		reserva1.setNoches(4);
		reserva1.setNumeroReserva(1234567);
		reserva1.setHabitacion(habitacion1);

		Cama cama1 = new Cama();
		cama1.setNroCama("c1");
		cama1.setTipoCama(Tipo.INDIVIDUAL);
		cama1.setEstadoCama(Estado.EN_OPERACION);
		cama1.setSituacionCama(SituacionActual.RESERVADA);
		cama1.setValorCama(0);

		listaCamas.add(cama1);

		habitacion1.setReserva(reserva1);
		habitacion1.setListCamas(listaCamas);

		Cama cama2 = new Cama();
		cama2.setNroCama("c2");
		cama2.setTipoCama(Tipo.DOBLE);
		cama2.setEstadoCama(Estado.EN_OPERACION);
		cama2.setSituacionCama(SituacionActual.DISPONIBLE);
		cama2.setValorCama(0);

		Cama cama3 = new Cama();
		cama3.setNroCama("c3");
		cama3.setTipoCama(Tipo.INDIVIDUAL);
		cama3.setEstadoCama(Estado.EN_OPERACION);
		cama3.setSituacionCama(SituacionActual.DISPONIBLE);
		cama3.setValorCama(0);

		Cama cama4 = new Cama();
		cama4.setNroCama("c4");
		cama4.setTipoCama(Tipo.DOBLE);
		cama4.setEstadoCama(Estado.EN_OPERACION);
		cama4.setSituacionCama(SituacionActual.DISPONIBLE);
		cama4.setValorCama(0);

		Cama cama5 = new Cama();
		cama5.setNroCama("c5");
		cama5.setTipoCama(Tipo.INDIVIDUAL);
		cama5.setEstadoCama(Estado.EN_OPERACION);
		cama5.setSituacionCama(SituacionActual.DISPONIBLE);
		cama5.setValorCama(0);

		Cama cama6 = new Cama();
		cama6.setNroCama("c6");
		cama6.setTipoCama(Tipo.DOBLE);
		cama6.setEstadoCama(Estado.EN_OPERACION);
		cama6.setSituacionCama(SituacionActual.DISPONIBLE);
		cama6.setValorCama(0);

		Cama cama7 = new Cama();
		cama7.setNroCama("c7");
		cama7.setTipoCama(Tipo.INDIVIDUAL);
		cama7.setEstadoCama(Estado.EN_OPERACION);
		cama7.setSituacionCama(SituacionActual.DISPONIBLE);
		cama7.setValorCama(0);

		Cama cama8 = new Cama();
		cama8.setNroCama("c8");
		cama8.setTipoCama(Tipo.DOBLE);
		cama8.setEstadoCama(Estado.EN_OPERACION);
		cama8.setSituacionCama(SituacionActual.DISPONIBLE);
		cama8.setValorCama(0);

		Cama cama9 = new Cama();
		cama9.setNroCama("c9");
		cama9.setTipoCama(Tipo.INDIVIDUAL);
		cama9.setEstadoCama(Estado.EN_OPERACION);
		cama9.setSituacionCama(SituacionActual.DISPONIBLE);
		cama9.setValorCama(0);

		Cama cama10 = new Cama();
		cama10.setNroCama("c10");
		cama10.setTipoCama(Tipo.DOBLE);
		cama10.setEstadoCama(Estado.EN_OPERACION);
		cama10.setSituacionCama(SituacionActual.DISPONIBLE);
		cama10.setValorCama(0);

		Cama cama11 = new Cama();
		cama11.setNroCama("c11");
		cama11.setTipoCama(Tipo.INDIVIDUAL);
		cama11.setEstadoCama(Estado.EN_OPERACION);
		cama11.setSituacionCama(SituacionActual.DISPONIBLE);
		cama11.setValorCama(0);

		Cama cama12 = new Cama();
		cama12.setNroCama("c12");
		cama12.setTipoCama(Tipo.INDIVIDUAL);
		cama12.setEstadoCama(Estado.EN_OPERACION);
		cama12.setSituacionCama(SituacionActual.DISPONIBLE);
		cama12.setValorCama(0);

		Cama cama13 = new Cama();
		cama13.setNroCama("c13");
		cama13.setTipoCama(Tipo.INDIVIDUAL);
		cama13.setEstadoCama(Estado.EN_OPERACION);
		cama13.setSituacionCama(SituacionActual.DISPONIBLE);
		cama13.setValorCama(0);

		Cama cama14 = new Cama();
		cama14.setNroCama("c14");
		cama14.setTipoCama(Tipo.INDIVIDUAL);
		cama14.setEstadoCama(Estado.EN_OPERACION);
		cama14.setSituacionCama(SituacionActual.DISPONIBLE);
		cama14.setValorCama(0);

		Cama cama15 = new Cama();
		cama15.setNroCama("c15");
		cama15.setTipoCama(Tipo.INDIVIDUAL);
		cama15.setEstadoCama(Estado.EN_OPERACION);
		cama15.setSituacionCama(SituacionActual.DISPONIBLE);
		cama15.setValorCama(0);

		Cama cama16 = new Cama();
		cama16.setNroCama("c16");
		cama16.setTipoCama(Tipo.INDIVIDUAL);
		cama16.setEstadoCama(Estado.EN_OPERACION);
		cama16.setSituacionCama(SituacionActual.DISPONIBLE);
		cama16.setValorCama(0);

		Cama cama17 = new Cama();
		cama17.setNroCama("c17");
		cama17.setTipoCama(Tipo.INDIVIDUAL);
		cama17.setEstadoCama(Estado.EN_OPERACION);
		cama17.setSituacionCama(SituacionActual.DISPONIBLE);
		cama17.setValorCama(0);

		Cama cama18 = new Cama();
		cama18.setNroCama("c18");
		cama18.setTipoCama(Tipo.INDIVIDUAL);
		cama18.setEstadoCama(Estado.EN_OPERACION);
		cama18.setSituacionCama(SituacionActual.DISPONIBLE);
		cama18.setValorCama(0);

		Cama cama19 = new Cama();
		cama19.setNroCama("c19");
		cama19.setTipoCama(Tipo.INDIVIDUAL);
		cama19.setEstadoCama(Estado.EN_OPERACION);
		cama19.setSituacionCama(SituacionActual.DISPONIBLE);
		cama19.setValorCama(0);

		Cama cama20 = new Cama();
		cama20.setNroCama("c20");
		cama20.setTipoCama(Tipo.INDIVIDUAL);
		cama20.setEstadoCama(Estado.EN_OPERACION);
		cama20.setSituacionCama(SituacionActual.DISPONIBLE);
		cama20.setValorCama(0);

		Cama cama21 = new Cama();
		cama21.setNroCama("c21");
		cama21.setTipoCama(Tipo.INDIVIDUAL);
		cama21.setEstadoCama(Estado.EN_OPERACION);
		cama21.setSituacionCama(SituacionActual.DISPONIBLE);
		cama21.setValorCama(0);

		Cama cama22 = new Cama();
		cama22.setNroCama("c22");
		cama22.setTipoCama(Tipo.INDIVIDUAL);
		cama22.setEstadoCama(Estado.EN_OPERACION);
		cama22.setSituacionCama(SituacionActual.DISPONIBLE);
		cama22.setValorCama(0);

		Cama cama23 = new Cama();
		cama23.setNroCama("c23");
		cama23.setTipoCama(Tipo.INDIVIDUAL);
		cama23.setEstadoCama(Estado.EN_OPERACION);
		cama23.setSituacionCama(SituacionActual.DISPONIBLE);
		cama23.setValorCama(0);

		Cama cama24 = new Cama();
		cama24.setNroCama("c24");
		cama24.setTipoCama(Tipo.INDIVIDUAL);
		cama24.setEstadoCama(Estado.EN_OPERACION);
		cama24.setSituacionCama(SituacionActual.DISPONIBLE);
		cama24.setValorCama(0);

		Cama cama25 = new Cama();
		cama25.setNroCama("c25");
		cama25.setTipoCama(Tipo.INDIVIDUAL);
		cama25.setEstadoCama(Estado.EN_OPERACION);
		cama25.setSituacionCama(SituacionActual.DISPONIBLE);
		cama25.setValorCama(0);

		Cama cama26 = new Cama();
		cama26.setNroCama("c26");
		cama26.setTipoCama(Tipo.INDIVIDUAL);
		cama26.setEstadoCama(Estado.EN_OPERACION);
		cama26.setSituacionCama(SituacionActual.DISPONIBLE);
		cama26.setValorCama(0);

		Cama cama27 = new Cama();
		cama27.setNroCama("c27");
		cama27.setTipoCama(Tipo.INDIVIDUAL);
		cama27.setEstadoCama(Estado.EN_OPERACION);
		cama27.setSituacionCama(SituacionActual.DISPONIBLE);
		cama27.setValorCama(0);

		Cama cama28 = new Cama();
		cama28.setNroCama("c28");
		cama28.setTipoCama(Tipo.INDIVIDUAL);
		cama28.setEstadoCama(Estado.EN_OPERACION);
		cama28.setSituacionCama(SituacionActual.DISPONIBLE);
		cama28.setValorCama(0);

		Cama cama29 = new Cama();
		cama29.setNroCama("c29");
		cama29.setTipoCama(Tipo.INDIVIDUAL);
		cama29.setEstadoCama(Estado.EN_OPERACION);
		cama29.setSituacionCama(SituacionActual.DISPONIBLE);
		cama29.setValorCama(0);

		Cama cama30 = new Cama();
		cama30.setNroCama("c30");
		cama30.setTipoCama(Tipo.INDIVIDUAL);
		cama30.setEstadoCama(Estado.EN_OPERACION);
		cama30.setSituacionCama(SituacionActual.DISPONIBLE);
		cama30.setValorCama(0);

		Cama cama31 = new Cama();
		cama31.setNroCama("c31");
		cama31.setTipoCama(Tipo.INDIVIDUAL);
		cama31.setEstadoCama(Estado.EN_OPERACION);
		cama31.setSituacionCama(SituacionActual.DISPONIBLE);
		cama31.setValorCama(0);

		Cama cama32 = new Cama();
		cama32.setNroCama("c32");
		cama32.setTipoCama(Tipo.INDIVIDUAL);
		cama32.setEstadoCama(Estado.EN_OPERACION);
		cama32.setSituacionCama(SituacionActual.DISPONIBLE);
		cama32.setValorCama(0);

		Cama cama33 = new Cama();
		cama33.setNroCama("c33");
		cama33.setTipoCama(Tipo.INDIVIDUAL);
		cama33.setEstadoCama(Estado.EN_OPERACION);
		cama33.setSituacionCama(SituacionActual.DISPONIBLE);
		cama33.setValorCama(0);

		Cama cama34 = new Cama();
		cama34.setNroCama("c34");
		cama34.setTipoCama(Tipo.INDIVIDUAL);
		cama34.setEstadoCama(Estado.EN_OPERACION);
		cama34.setSituacionCama(SituacionActual.DISPONIBLE);
		cama34.setValorCama(0);

		Cama cama35 = new Cama();
		cama35.setNroCama("c35");
		cama35.setTipoCama(Tipo.INDIVIDUAL);
		cama35.setEstadoCama(Estado.EN_OPERACION);
		cama35.setSituacionCama(SituacionActual.DISPONIBLE);
		cama35.setValorCama(0);

		Cama cama36 = new Cama();
		cama36.setNroCama("c36");
		cama36.setTipoCama(Tipo.INDIVIDUAL);
		cama36.setEstadoCama(Estado.EN_OPERACION);
		cama36.setSituacionCama(SituacionActual.DISPONIBLE);
		cama36.setValorCama(0);

		Cama cama37 = new Cama();
		cama37.setNroCama("c37");
		cama37.setTipoCama(Tipo.INDIVIDUAL);
		cama37.setEstadoCama(Estado.EN_OPERACION);
		cama37.setSituacionCama(SituacionActual.DISPONIBLE);
		cama37.setValorCama(0);

		Cama cama38 = new Cama();
		cama38.setNroCama("c38");
		cama38.setTipoCama(Tipo.INDIVIDUAL);
		cama38.setEstadoCama(Estado.EN_OPERACION);
		cama38.setSituacionCama(SituacionActual.DISPONIBLE);
		cama38.setValorCama(0);

		Cama cama39 = new Cama();
		cama39.setNroCama("c39");
		cama39.setTipoCama(Tipo.INDIVIDUAL);
		cama39.setEstadoCama(Estado.EN_OPERACION);
		cama39.setSituacionCama(SituacionActual.DISPONIBLE);
		cama39.setValorCama(0);

		Cama cama40 = new Cama();
		cama40.setNroCama("c40");
		cama40.setTipoCama(Tipo.INDIVIDUAL);
		cama40.setEstadoCama(Estado.EN_OPERACION);
		cama40.setSituacionCama(SituacionActual.DISPONIBLE);
		cama40.setValorCama(0);

		Cama cama41 = new Cama();
		cama41.setNroCama("c41");
		cama41.setTipoCama(Tipo.INDIVIDUAL);
		cama41.setEstadoCama(Estado.EN_OPERACION);
		cama41.setSituacionCama(SituacionActual.DISPONIBLE);
		cama41.setValorCama(0);

		Cama cama42 = new Cama();
		cama42.setNroCama("c42");
		cama42.setTipoCama(Tipo.INDIVIDUAL);
		cama42.setEstadoCama(Estado.EN_OPERACION);
		cama42.setSituacionCama(SituacionActual.DISPONIBLE);
		cama42.setValorCama(0);

		Cama cama43 = new Cama();
		cama43.setNroCama("c43");
		cama43.setTipoCama(Tipo.INDIVIDUAL);
		cama43.setEstadoCama(Estado.EN_OPERACION);
		cama43.setSituacionCama(SituacionActual.DISPONIBLE);
		cama43.setValorCama(0);

		Cama cama44 = new Cama();
		cama44.setNroCama("c44");
		cama44.setTipoCama(Tipo.INDIVIDUAL);
		cama44.setEstadoCama(Estado.EN_OPERACION);
		cama44.setSituacionCama(SituacionActual.DISPONIBLE);
		cama44.setValorCama(0);

		Cama cama45 = new Cama();
		cama45.setNroCama("c45");
		cama45.setTipoCama(Tipo.INDIVIDUAL);
		cama45.setEstadoCama(Estado.EN_OPERACION);
		cama45.setSituacionCama(SituacionActual.DISPONIBLE);
		cama45.setValorCama(0);

		listaCamas2.add(cama2);
		listaCamas2.add(cama3);

		ArrayList<Cama> listaCamas3 = new ArrayList<>();
		ArrayList<Cama> listaCamas4 = new ArrayList<>();
		ArrayList<Cama> listaCamas5 = new ArrayList<>();
		ArrayList<Cama> listaCamas6 = new ArrayList<>();
		ArrayList<Cama> listaCamas7 = new ArrayList<>();
		ArrayList<Cama> listaCamas8 = new ArrayList<>();
		ArrayList<Cama> listaCamas9 = new ArrayList<>();
		ArrayList<Cama> listaCamas10 = new ArrayList<>();
		ArrayList<Cama> listaCamas11 = new ArrayList<>();
		ArrayList<Cama> listaCamas12 = new ArrayList<>();
		ArrayList<Cama> listaCamas13 = new ArrayList<>();
		ArrayList<Cama> listaCamas14 = new ArrayList<>();
		ArrayList<Cama> listaCamas15 = new ArrayList<>();
		ArrayList<Cama> listaCamas16 = new ArrayList<>();
		ArrayList<Cama> listaCamas17 = new ArrayList<>();
		ArrayList<Cama> listaCamas18 = new ArrayList<>();
		ArrayList<Cama> listaCamas19 = new ArrayList<>();
		ArrayList<Cama> listaCamas20 = new ArrayList<>();

		listaCamas3.add(cama25);
		listaCamas4.add(cama8);
		listaCamas4.add(cama26);
		listaCamas5.add(cama40);
		listaCamas6.add(cama39);
		listaCamas6.add(cama16);
		listaCamas7.add(cama33);
		listaCamas8.add(cama4);
		listaCamas9.add(cama38);
		listaCamas10.add(cama6);
		listaCamas11.add(cama21);
		listaCamas12.add(cama17);
		listaCamas12.add(cama37);
		listaCamas13.add(cama16);
		listaCamas14.add(cama23);
		listaCamas14.add(cama20);
		listaCamas14.add(cama11);
		listaCamas15.add(cama24);
		listaCamas16.add(cama10);
		listaCamas17.add(cama43);
		listaCamas18.add(cama18);
		listaCamas18.add(cama5);
		listaCamas19.add(cama13);
		listaCamas20.add(cama30);
		listaCamas20.add(cama7);

		habitacion2.setListCamas(listaCamas2);
		habitacion3.setListCamas(listaCamas3);

		listaHabitaciones.add(habitacion1);
		listaHabitaciones.add(habitacion2);
		listaHabitaciones.add(habitacion3);

		listaReservas.add(reserva1);

		Habitacion habitacion4 = new Habitacion();
		habitacion4.setNumeroHabitacion(104);
		habitacion4.setTipoHabitacion(Tipo.DOBLE);
		habitacion4.setEstadoHabitacion(Estado.EN_OPERACION);
		habitacion4.setValorHabitacion(300000);

		Habitacion habitacion5 = new Habitacion();
		habitacion5.setNumeroHabitacion(105);
		habitacion5.setTipoHabitacion(Tipo.INDIVIDUAL);
		habitacion5.setSituacion(SituacionActual.DISPONIBLE);
		habitacion5.setEstadoHabitacion(Estado.EN_OPERACION);
		habitacion5.setValorHabitacion(500000);

		Habitacion habitacion6 = new Habitacion();
		habitacion6.setNumeroHabitacion(106);
		habitacion6.setTipoHabitacion(Tipo.DOBLE);
		habitacion6.setSituacion(SituacionActual.DISPONIBLE);
		habitacion6.setEstadoHabitacion(Estado.EN_OPERACION);
		habitacion6.setValorHabitacion(500000);

		Habitacion habitacion7 = new Habitacion();
		habitacion7.setNumeroHabitacion(107);
		habitacion7.setTipoHabitacion(Tipo.INDIVIDUAL);
		habitacion7.setSituacion(SituacionActual.DISPONIBLE);
		habitacion7.setEstadoHabitacion(Estado.EN_OPERACION);
		habitacion7.setValorHabitacion(500000);

		Habitacion habitacion8 = new Habitacion();
		habitacion8.setNumeroHabitacion(108);
		habitacion8.setTipoHabitacion(Tipo.DOBLE);
		habitacion8.setSituacion(SituacionActual.DISPONIBLE);
		habitacion8.setEstadoHabitacion(Estado.EN_OPERACION);
		habitacion8.setValorHabitacion(500000);

		Habitacion habitacion9 = new Habitacion();
		habitacion9.setNumeroHabitacion(109);
		habitacion9.setTipoHabitacion(Tipo.INDIVIDUAL);
		habitacion9.setSituacion(SituacionActual.DISPONIBLE);
		habitacion9.setEstadoHabitacion(Estado.EN_OPERACION);
		habitacion9.setValorHabitacion(500000);

		Habitacion habitacion10 = new Habitacion();
		habitacion10.setNumeroHabitacion(110);
		habitacion10.setTipoHabitacion(Tipo.DOBLE);
		habitacion10.setSituacion(SituacionActual.DISPONIBLE);
		habitacion10.setEstadoHabitacion(Estado.EN_OPERACION);
		habitacion10.setValorHabitacion(500000);

		Habitacion habitacion11 = new Habitacion();
		habitacion11.setNumeroHabitacion(201);
		habitacion11.setTipoHabitacion(Tipo.INDIVIDUAL);
		habitacion11.setSituacion(SituacionActual.DISPONIBLE);
		habitacion11.setEstadoHabitacion(Estado.EN_OPERACION);
		habitacion11.setValorHabitacion(500000);

		Habitacion habitacion12 = new Habitacion();
		habitacion12.setNumeroHabitacion(202);
		habitacion12.setTipoHabitacion(Tipo.DOBLE);
		habitacion12.setSituacion(SituacionActual.DISPONIBLE);
		habitacion12.setEstadoHabitacion(Estado.EN_OPERACION);
		habitacion12.setValorHabitacion(500000);

		Habitacion habitacion13 = new Habitacion();
		habitacion13.setNumeroHabitacion(203);
		habitacion13.setTipoHabitacion(Tipo.INDIVIDUAL);
		habitacion13.setSituacion(SituacionActual.DISPONIBLE);
		habitacion13.setEstadoHabitacion(Estado.EN_OPERACION);
		habitacion13.setValorHabitacion(500000);

		Habitacion habitacion14 = new Habitacion();
		habitacion14.setNumeroHabitacion(204);
		habitacion14.setTipoHabitacion(Tipo.DOBLE);
		habitacion14.setSituacion(SituacionActual.DISPONIBLE);
		habitacion14.setEstadoHabitacion(Estado.EN_OPERACION);
		habitacion14.setValorHabitacion(500000);

		Habitacion habitacion15 = new Habitacion();
		habitacion15.setNumeroHabitacion(205);
		habitacion15.setTipoHabitacion(Tipo.INDIVIDUAL);
		habitacion15.setSituacion(SituacionActual.DISPONIBLE);
		habitacion15.setEstadoHabitacion(Estado.EN_OPERACION);
		habitacion15.setValorHabitacion(500000);

		Habitacion habitacion16 = new Habitacion();
		habitacion16.setNumeroHabitacion(206);
		habitacion16.setTipoHabitacion(Tipo.DOBLE);
		habitacion16.setSituacion(SituacionActual.DISPONIBLE);
		habitacion16.setEstadoHabitacion(Estado.EN_OPERACION);
		habitacion16.setValorHabitacion(500000);

		Habitacion habitacion17 = new Habitacion();
		habitacion17.setNumeroHabitacion(207);
		habitacion17.setTipoHabitacion(Tipo.INDIVIDUAL);
		habitacion17.setSituacion(SituacionActual.DISPONIBLE);
		habitacion17.setEstadoHabitacion(Estado.EN_OPERACION);
		habitacion17.setValorHabitacion(500000);

		Habitacion habitacion18 = new Habitacion();
		habitacion18.setNumeroHabitacion(208);
		habitacion18.setTipoHabitacion(Tipo.DOBLE);
		habitacion18.setSituacion(SituacionActual.DISPONIBLE);
		habitacion18.setEstadoHabitacion(Estado.EN_OPERACION);
		habitacion18.setValorHabitacion(500000);

		Habitacion habitacion19 = new Habitacion();
		habitacion19.setNumeroHabitacion(209);
		habitacion19.setTipoHabitacion(Tipo.INDIVIDUAL);
		habitacion19.setSituacion(SituacionActual.DISPONIBLE);
		habitacion19.setEstadoHabitacion(Estado.EN_OPERACION);
		habitacion19.setValorHabitacion(500000);

		Habitacion habitacion20 = new Habitacion();
		habitacion20.setNumeroHabitacion(210);
		habitacion20.setTipoHabitacion(Tipo.DOBLE);
		habitacion20.setSituacion(SituacionActual.DISPONIBLE);
		habitacion20.setEstadoHabitacion(Estado.EN_OPERACION);
		habitacion20.setValorHabitacion(500000);

		Reserva reserva2 = new Reserva();
		reserva2.setDiaEntrada(LocalDate.of(2023, 9, 1));
		reserva2.setDiaSalida(LocalDate.of(2023, 9, 5));
		reserva2.setNoches(6);
		reserva2.setNumeroReserva(876543);
		reserva2.setHabitacion(habitacion11);

		Reserva reserva3 = new Reserva();
		reserva3.setDiaEntrada(LocalDate.of(2023, 10, 8));
		reserva3.setDiaSalida(LocalDate.of(2023, 10, 15));
		reserva3.setNoches(7);
		reserva3.setNumeroReserva(897657);
		reserva3.setHabitacion(habitacion18);

		Reserva reserva4 = new Reserva();
		reserva4.setDiaEntrada(LocalDate.of(2023, 12, 1));
		reserva4.setDiaSalida(LocalDate.of(2023, 12, 9));
		reserva4.setNoches(8);
		reserva4.setNumeroReserva(7840203);
		reserva4.setHabitacion(habitacion16);

		Reserva reserva5 = new Reserva();
		reserva5.setDiaEntrada(LocalDate.of(2023, 12, 23));
		reserva5.setDiaSalida(LocalDate.of(2023, 12, 30));
		reserva5.setNoches(7);
		reserva5.setNumeroReserva(1276908);
		reserva5.setHabitacion(habitacion4);

		habitacion11.setReserva(reserva2);
		habitacion18.setReserva(reserva3);
		habitacion16.setReserva(reserva4);
		habitacion4.setReserva(reserva5);

		habitacion4.setListCamas(listaCamas4);
		habitacion5.setListCamas(listaCamas5);
		habitacion6.setListCamas(listaCamas6);
		habitacion7.setListCamas(listaCamas7);
		habitacion8.setListCamas(listaCamas8);
		habitacion9.setListCamas(listaCamas9);
		habitacion10.setListCamas(listaCamas10);
		habitacion11.setListCamas(listaCamas11);
		habitacion12.setListCamas(listaCamas12);
		habitacion13.setListCamas(listaCamas13);
		habitacion14.setListCamas(listaCamas14);
		habitacion15.setListCamas(listaCamas15);
		habitacion16.setListCamas(listaCamas16);
		habitacion17.setListCamas(listaCamas17);
		habitacion18.setListCamas(listaCamas18);
		habitacion19.setListCamas(listaCamas19);
		habitacion20.setListCamas(listaCamas20);

		listaHabitaciones.add(habitacion4);
		listaHabitaciones.add(habitacion5);
		listaHabitaciones.add(habitacion6);
		listaHabitaciones.add(habitacion7);
		listaHabitaciones.add(habitacion8);
		listaHabitaciones.add(habitacion9);
		listaHabitaciones.add(habitacion10);
		listaHabitaciones.add(habitacion11);
		listaHabitaciones.add(habitacion12);
		listaHabitaciones.add(habitacion13);
		listaHabitaciones.add(habitacion14);
		listaHabitaciones.add(habitacion15);
		listaHabitaciones.add(habitacion16);
		listaHabitaciones.add(habitacion17);
		listaHabitaciones.add(habitacion18);
		listaHabitaciones.add(habitacion19);
		listaHabitaciones.add(habitacion20);

		listaReservas.add(reserva2);
		listaReservas.add(reserva3);
		listaReservas.add(reserva4);
		listaReservas.add(reserva5);

		ArrayList<Reserva> listaReservaCliente1 = new ArrayList<>();
		Cliente cliente = new Cliente();
		cliente.setNombre("Daniela");
		cliente.setCedula("1094555018");
		cliente.setTelefono("3256784");
		cliente.setCorreo("daniela@gmail.com");
		listaReservaCliente1.add(reserva4);
		cliente.setListReservas(listaReservaCliente1);

		ArrayList<Reserva> listaReservaCliente2 = new ArrayList<>();
		Cliente cliente2 = new Cliente();
		cliente2.setNombre("Santiago");
		cliente2.setCedula("11548765464");
		cliente2.setTelefono("79875487");
		cliente2.setCorreo("santiago@gmail.com");
		listaReservaCliente2.add(reserva3);
		cliente2.setListReservas(listaReservaCliente2);

		ArrayList<Reserva> listaReservaCliente3 = new ArrayList<>();
		Cliente cliente3 = new Cliente();
		cliente3.setNombre("Ximena");
		cliente3.setCedula("1095550251");
		cliente3.setTelefono("454675");
		cliente3.setCorreo("ximena@gmail.com");
		listaReservaCliente3.add(reserva2);
		cliente3.setListReservas(listaReservaCliente3);

		listaPersonas.add(cliente);
		listaPersonas.add(cliente2);
		listaPersonas.add(cliente3);

		hotel.setListPersona(listaPersonas);
		hotel.setListHabitaciones(listaHabitaciones);
		hotel.setListReservas(listaReservas);

		System.out.println(hotel.getListHabitaciones());
		System.out.println(hotel.getListPersona());
		System.out.println(hotel.getListReservas());

	}

	// Get y set de Hotel
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	// Metodo que verifica en el hotel si es valido el recepcionista que desea
	// ingresar

	public boolean verificarRecepcionista(String documentoRecep, String contraseniaRecep) {
//		if(red.verificarDocumento(documento, contrasenia)){
//			Persistencia.guardaRegistroLog("Inicio de sesion del usuario: "+documento, 1, "inicio Sesion");
//		}else{
//			Persistencia.guardaRegistroLog("Error de sesion del usuario", 2, "inicio Sesion");
//		}
		return hotel.verificarRecep(documentoRecep, contraseniaRecep);
	}

	// Metodo que devuelve las habitaciones del hotel
	public ArrayList<Habitacion> obtenerHabitaciones() {
		return hotel.getListHabitaciones();
	}

	// Procedimiento que muestra el estado de una habitacion en determinada fecha
	public void verificarEstado(LocalDate fechaSeleccionada, int numeroHabitacion) {
		hotel.actualizarEstado(fechaSeleccionada, numeroHabitacion);
	}

	// Metodo que devuelve todas las camas
	public ArrayList<Cama> obtenerCamas() {
		return hotel.retornarCamas();
	}

	// Procedimiento que muestra el estado de una cama en determinada fecha
	public void verificarEstadoCama(LocalDate fechaSeleccionada, String nroCama) {
		hotel.actualizarEstadoCama(fechaSeleccionada, nroCama);
	}

	// Metodo que devuelve el numero de habitaci�n en la que se encuentra una cama
	public String devolverNroH(String nroCama) {
		return hotel.devolverNroH(nroCama);
	}

	// Metodo que verifica la disponibilidad de una habitacion doble en determinada
	// fecha
	public String verificarDisponibilidad(LocalDate fechaSeleccionadaH) {
		return hotel.devolverDisponibilidad(fechaSeleccionadaH);
	}

	// Metodo que verifica la disponibilidad de una habitacion individual en
	// determinada fecha
	public String verificarDisponibilidad2(LocalDate fechaSeleccionadaH) {
		return hotel.devolverDisponibilidadI(fechaSeleccionadaH);
	}

	// Metodo que verifica la disponibilidad de una cama doble en determinada fecha
	public String verificarDisponibilidadC1(LocalDate fechaSeleccionadaC) {
		return hotel.devolverDisponibilidadCamasD(fechaSeleccionadaC);
	}

	// Metodo que verifica la disponibilidad de una cama individual en determinada
	// fecha
	public String verificarDisponibilidadC2(LocalDate fechaSeleccionadaC) {
		return hotel.devolverDisponibilidadCamasI(fechaSeleccionadaC);
	}

	// Metodo que verifica si una habitacion esta disponible en el rango de fecha
	// entre la fechaInicio y fechaSalida de reserva
	public ArrayList<Integer> verificarHabitacion(LocalDate fechaInicio, LocalDate fechaSalida) {
		return hotel.verificarHabitacion(fechaInicio, fechaSalida);
	}

	// Metodo que crea la reserva
	public Reserva crearReserva(LocalDate fechaInicio, LocalDate fechaSalida, int numeroReserva, String habitacion)
			throws ReservaException {
		Persistencia.guardarRecursoBancoXML(hotel);
		return hotel.crearReserva(fechaInicio, fechaSalida, numeroReserva, habitacion);
	}

	// Metodo que devuelve el nro de camas en una habitacion
	public int devolverNroCamas(String habitacion) {
		return hotel.devolverCamas(habitacion);
	}

	// Metodo que calcula el pago total de una habitacion
	public int calcularPago(String selectedState) {
		return hotel.calcularPagoReserva(selectedState);
	}

	// Metodo que crea el cliente
	public Cliente crearCliente(String nombre, String cedula, Reserva reserva) throws ClienteException {
		Persistencia.guardarRecursoBancoXML(hotel);
		return hotel.crearCliente(nombre, cedula, reserva);
	}

	// Metodo de busqueda por parte del recepcionista con el nombre del cliente
	public boolean obtenerInformacion(String nombre) {
		return hotel.obtenerInfo(nombre);
	}

	// Metodo que registra el cliente, por parte del recepcionista
	public Cliente registrarCliente(String nombre, String documento, String telefono, String correo)
			throws ClienteException {
		Persistencia.guardarRecursoBancoXML(hotel);
		return hotel.registrarCliente(nombre, documento, telefono, correo);

	}

}
