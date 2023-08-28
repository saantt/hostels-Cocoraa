package controllers;

import java.time.LocalDate;

import aplication.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ConfirmacionReservaController {
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
	    private Label labelNroReserva;

	    @FXML
	    private Label labelMetodoPago;
	    
	    private Aplicacion aplicacion; 
		
		ModelFactoryController modelFactoryController;
		
		private LocalDate fechaInicio; 
		
		private LocalDate fechaSalida;
		
		private String habitacion; 
		
		private int numeroReserva;
		
		private String opcionSeleccionada;
		
		private String tipoH;
		
		private int camas;
		
		private String pago;
		
		   @FXML
		    private Button btnRegresar;

		    @FXML
		    void regresarEvent(ActionEvent event) {
		    	aplicacion.mostrarVentanaIniciar();
		    }

		
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
			labelTipoHReserva.setText(tipoH);
			labelNroCamasReserva.setText(Integer.toString(camas));
			labelTotalReserva.setText(pago);
		}
	    
	    @FXML
	    void initialize() {
			modelFactoryController = ModelFactoryController.getInstance();
			
		}
	    
	    

}
