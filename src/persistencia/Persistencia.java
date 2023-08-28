package persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import model.Habitacion;
import model.Hotel;
import model.Persona;
import model.Reserva;

public class Persistencia {

	public static final String RUTA_ARCHIVO_ANUNCIANTES = "C://td//persistencia//archivos//archivoAnunciantes.txt";
	public static final String RUTA_ARCHIVO_COMPRADORES = "C://td//persistencia//archivos//archivoCompradores.txt";
	public static final String RUTA_ARCHIVO_RESPALDO_ANUNCIANTES_ = "C://td//persistencia//respaldo//archivoAnunciantes.txt";
	public static final String RUTA_ARCHIVO_RESPALDO_COMPRADORES = "C://td//persistencia//respaldo//archivoCompradores.txt";
	public static final String RUTA_ARCHIVO_RESPALDO_LOG = "C://td//persistencia//respaldo//Log.txt";
	public static final String RUTA_ARCHIVO_RESPALDO_OBJETOS = "C://td//persistencia//respaldo//Objetos.txt";
	public static final String RUTA_ARCHIVO_RESPALDO_BINARIO = "C://td//persistencia//respaldo//Binario.txt";
	public static final String RUTA_ARCHIVO_RESPALDO_XML = "C://td//persistencia//respaldo//XML.txt";
	public static final String RUTA_ARCHIVO_LOG = "C://td//persistencia//log//SubastaLog.txt";
	public static final String RUTA_ARCHIVO_OBJETOS = "src/resources/archivoObjetos.txt";
	public static final String RUTA_ARCHIVO_MODELO_SUBASTA_BINARIO = "C://td//persistencia//model.dat";
	public static final String RUTA_ARCHIVO_MODELO_SUBASTA_XML = "C://td//persistencia//modelHotel.xml";

//	public static void cargarDatosArchivos(Hotel hotel) throws FileNotFoundException, IOException {
//
//		// cargar archivo de anunciante
//		ArrayList<Persona> anunciantesCargados = cargarPersonas();
//
//		if (anunciantesCargados.size() > 0)
//			hotel.getListPersona().addAll(anunciantesCargados);
//
//		// cargar archivos comprador
//		ArrayList<Reserva> compradoresCargados = cargarReservas();
//
//		if (compradoresCargados.size() > 0)
//			hotel.getListReservas().addAll(compradoresCargados);
//
//		// cargar archivos comprador
//		ArrayList<Habitacion> habitacionesCargadas = cargarHabitaciones();
//
//		if (compradoresCargados.size() > 0)
//			hotel.getListHabitaciones().addAll(habitacionesCargadas);
//	}
//
//	/**
//	 * Guarda en un archivo de texto todos la informaci�n de las personas
//	 * almacenadas en el ArrayList
//	 * 
//	 *
//	 * @throws IOException
//	 */
//	public static void guardarPersonas(ArrayList<Persona> listaPersonas) throws IOException {
//		// TODO Auto-generated method stub
//		String contenido = "";
//
//		for (Persona persona : listaPersonas) {
//			contenido += persona.getNombre() + "@" + "@" + persona.getCedula() + "@" + "@"
//					+ persona.getCorreo() + "@" + "@" + persona.getTelefono() + "\n";
//		}
//		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_ANUNCIANTES, contenido, false);
//		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_RESPALDO_ANUNCIANTES_, contenido, false);
//
//	}

//	public static void guardarCompradores(ArrayList<Comprador> listaCompradores) throws IOException {
//		// TODO Auto-generated method stub
//		String contenido = "";
//
//		for (Comprador comprador : listaCompradores) {
//			contenido += comprador.getNombre() + "@" + "@" + comprador.getApellido() + "@" + "@"
//					+ comprador.getIdentificacion() + "@" + "@" + comprador.getEdad() + "\n";
//		}
//		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_COMPRADORES, contenido, false);
//		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_RESPALDO_COMPRADORES, contenido, false);
//
//	}

	/**
	 * 
	 * 
	 * @return un Arraylist de personas con los datos obtenidos del archivo de texto
	 *         indicado
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
//	public static ArrayList<Persona> cargarPersonas() throws FileNotFoundException, IOException {
//		ArrayList<Persona> personas = new ArrayList<Persona>();
//
//		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_ANUNCIANTES);
//		String linea = "";
//
//		for (int i = 0; i < contenido.size(); i++) {
//			linea = contenido.get(i);
//			Persona persona = new Persona();
//			persona.setNombre(linea.split("@" + "@")[0]);
//			persona.setCedula(linea.split("@" + "@")[1]);
//			persona.setCorreo(linea.split("@" + "@")[2]);
//			persona.setTelefono(linea.split("@" + "@")[3]);
//			personas.add(persona);
//		}
//		return personas;
//	}
//
//	public static ArrayList<Comprador> cargarCompradores() throws FileNotFoundException, IOException {
//
//		ArrayList<Comprador> compradores = new ArrayList<Comprador>();
//
//		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_COMPRADORES);
//		String linea = "";
//
//		for (int i = 0; i < contenido.size(); i++) {
//			linea = contenido.get(i);
//			Comprador comprador = new Comprador();
//			comprador.setCe(linea.split("@" + "@")[0]);
//			comprador.setApellido(linea.split("@" + "@")[1]);
//			comprador.setIdentificacion(linea.split("@" + "@")[2]);
//			comprador.setEdad(linea.split("@" + "@")[3]);
//			compradores.add(comprador);
//		}
//		return compradores;
//
//	}
//
//	public static void guardaRegistroLog(String mensajeLog, int nivel, String accion) {
//
//		ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
//		ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_RESPALDO_LOG);
//
//	}
//
//	/**
//	 * Guarda en un archivo de texto todos la informaci�n de las personas
//	 * almacenadas en el ArrayList
//	 *
//	 * @throws IOException
//	 */
//
//	public static void guardarObjetos(ArrayList<Anunciante> listaAnunciantes, String ruta) throws IOException {
//		String contenido = "";
//
//		for (Anunciante anuncianteAux : listaAnunciantes) {
//			contenido += anuncianteAux.getNombre() + "," + anuncianteAux.getApellido() + ","
//					+ anuncianteAux.getIdentificacion() + "," + anuncianteAux.getEdad() + "\n";
//		}
//		ArchivoUtil.guardarArchivo(ruta, contenido, true);
//	}

//	public static Hotel cargarRecursoBancoBinario() {
//
//		Hotel subasta = null;
//
//		try {
//			subasta = (Hotel) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_SUBASTA_BINARIO);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return subasta;
//	}
//
//	public static void guardarRecursoBancoBinario(Hotel hotel) {
//
//		try {
//			ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_SUBASTA_BINARIO, hotel);
//			ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_RESPALDO_BINARIO, hotel);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public static Hotel cargarRecursoBancoXML() {

		Hotel hotel = null;

		try {
			hotel = (Hotel) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_SUBASTA_XML);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hotel;

	}

	public static void guardarRecursoBancoXML(Hotel hotel) {

		try {
			ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_SUBASTA_XML, hotel);
			ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_RESPALDO_XML, hotel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}