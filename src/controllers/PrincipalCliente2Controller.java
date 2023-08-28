package controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

import javax.swing.JOptionPane;

import aplication.Aplicacion;
import exceptions.ClienteException;
import exceptions.ReservaException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Duration;
import model.Cliente;
import model.Reserva;

public class PrincipalCliente2Controller {
	
	//Atributos del controlador

    @FXML
    private Label labelFechaIngreso;

    @FXML
    private Label labelFechaSalida;

    @FXML
    private Label labelNumeroHReserva;

    @FXML
    private Label labelTipoHReserva;

    @FXML
    private Label labelNroCamasReserva;

    @FXML
    private Label labelTotalReserva;

    @FXML
    private Button btnPagar;
    
    private Aplicacion aplicacion; 
	
	ModelFactoryController modelFactoryController;
	
	private LocalDate fechaInicio; 
	
	private LocalDate fechaSalida;
	
	private String habitacion; 
	
	private String tipoH;
	
	private int camas;
	
	private String pago;
	
	  @FXML
	    private Label timeLabel;

	//Evento del boton pagar
    @FXML
    void PagarEvent(ActionEvent event) {
    	pagarAction();
    }
    
    //Accion que obtiene todos los datos para posteriormente mostrar la informaci�n en la
    //ventana de confirmaci�n
    private void pagarAction() {
		String nombre= JOptionPane.showInputDialog("Ingrese su nombre para continuar con la reserva");
		String cedula= JOptionPane.showInputDialog("Ingrese su cedula para continuar con la reserva");
		Random random = new Random();
        int numeroReserva = 100000 + random.nextInt(900000);
        String opcionSeleccionada= "";
		String [] botones = { "Recepcion", "Tarjeta Debito/Credito", "PSE"};
		int variable = JOptionPane.showOptionDialog (null, "�Por qu� medio desea realizar su pago?", "Metodos de pago", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);
		if (variable >= 0 && variable < botones.length) {
            opcionSeleccionada = botones[variable];
		}
		crearReservaCliente(numeroReserva, nombre, cedula,opcionSeleccionada);
		
	}
    
    //Procedimiento donde se crea la reserva y el cliente
    public void crearReservaCliente( int numeroReserva, String nombre, String cedula, String opcionSeleccionada){
    	Reserva reserva = null;
		Cliente cliente = null;
		try {
			reserva=modelFactoryController.crearReserva(fechaInicio, fechaSalida, numeroReserva, habitacion);
			try {
				cliente= modelFactoryController.crearCliente(nombre, cedula, reserva);
			} catch (ClienteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	aplicacion.mostrarVentanaCliente3(fechaInicio, fechaSalida, habitacion, numeroReserva, opcionSeleccionada, tipoH, camas, pago);
		} catch (ReservaException e) {

			mostrarMensaje("Notificacion reserva", "Reserva invalida", "Hubo un error al realizar la reserva", AlertType.ERROR);
		}
		
    	
    }
    
    public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

		Alert alert = new Alert(alertType);
		alert.setTitle(titulo);
		alert.setHeaderText(header);
		alert.setContentText(contenido);
		alert.showAndWait();
	}

	public void setAplicacion(Aplicacion aplicacion, LocalDate fechaInicio, LocalDate fechaSalida,
			String habitacion, String tipoH, int camas, String pago) {
		this.aplicacion = aplicacion;
		this.aplicacion = aplicacion;
		this.fechaInicio = fechaInicio; 
		this.fechaSalida = fechaSalida; 
		this.habitacion = habitacion; 
		this.tipoH = tipoH;
		this.camas= camas;
		this.pago= pago;
		
		labelFechaIngreso.setText(fechaInicio.toString());
		labelFechaSalida.setText(fechaSalida.toString());
		labelNumeroHReserva.setText(habitacion);
		labelTipoHReserva.setText(tipoH);
		labelNroCamasReserva.setText(Integer.toString(camas));
		labelTotalReserva.setText(pago);
	}
    
    @FXML
    void initialize() {
		modelFactoryController = ModelFactoryController.getInstance();
		updateClock();
		Timeline timeline = new Timeline(
	            new KeyFrame(Duration.minutes(1), event -> updateClock())
	        );
	        timeline.setCycleCount(Timeline.INDEFINITE);
	        timeline.play();
		
	}
	
	public void updateClock() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a");
        String currentTime = sdf.format(new Date());
        timeLabel.setText(currentTime);
    }
	
}
