package controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import aplication.Aplicacion;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class PrincipalCliente3Controller {
	
	//Atributos del controlador 
	  @FXML
	    private Label labelNroReserva;

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
	    private Label labelMetodoPago;

	    @FXML
	    private Label labelTotalReserva;
	    
	    private Aplicacion aplicacion; 
	    
	    private LocalDate fechaInicio; 
		
		private LocalDate fechaSalida;
		
		private String habitacion; 
		
		private int numeroReserva;
		
		private String opcionSeleccionada;
		
		private int camas;
		
		private String pago;
		
		private String tipoH;
		
		ModelFactoryController modelFactoryController;
		
		@FXML
	    private Label timeLabel;
		
		public void setAplicacion(Aplicacion aplicacion, LocalDate fechaInicio, LocalDate fechaSalida,
				String habitacion, int numeroReserva, String opcionSeleccionada, String tipoH, int camas, String pago) {
			this.aplicacion = aplicacion;
			this.fechaInicio = fechaInicio; 
			this.fechaSalida = fechaSalida; 
			this.habitacion = habitacion; 
			this.numeroReserva = numeroReserva; 
			this.opcionSeleccionada = opcionSeleccionada;
			this.tipoH = tipoH;
			this.camas= camas;
			this.pago= pago;
			
			labelFechaIngreso.setText(fechaInicio.toString());
			labelFechaSalida.setText(fechaSalida.toString());
			labelNroReserva.setText(Integer.toString(numeroReserva));
			labelNumeroHReserva.setText(habitacion);
			labelMetodoPago.setText(opcionSeleccionada);
			labelNroCamasReserva.setText(Integer.toString(camas));
			labelTipoHReserva.setText(tipoH);
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
