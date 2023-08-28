package controllers;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import aplication.Aplicacion;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.util.Duration;
import javafx.scene.control.Alert.AlertType;


public class PrincipalClienteController {
	
	//Atributos del controlador
	 @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private DatePicker datePickerFechaE;

	    @FXML
	    private DatePicker datePickerFechaS;

	    @FXML
	    private ComboBox<String> comboBoxReserva;

	    @FXML
	    private ComboBox<Integer> comboBoxHabitacion;

	    @FXML
	    private Button btnReservar;
	
	private Aplicacion aplicacion; 
	
	ModelFactoryController modelFactoryController;
	
	@FXML
    private Label timeLabel;
	
	//Evento del boton reservar
	@FXML
    void reservarEvent(ActionEvent event) {
		reservarAction();

    }
	
	//Accion donde se capturan los datos ingresados por el cliente y se envian a la 
	//2da ventana del cliente
	
	private void reservarAction() {
		LocalDate fechaInicio = datePickerFechaE.getValue();
        LocalDate fechaSalida = datePickerFechaS.getValue();
        String habitacion= Integer.toString(comboBoxHabitacion.getSelectionModel().getSelectedItem());
        String tipoH = comboBoxReserva.getSelectionModel().getSelectedItem();
		int camas= modelFactoryController.devolverNroCamas(habitacion);
		String pago= Integer.toString(modelFactoryController.calcularPago(tipoH));
		 aplicacion.mostrarVentanaCliente2(fechaInicio, fechaSalida, habitacion, tipoH, camas, pago);
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}
	
	@FXML
    void initialize() {
		modelFactoryController = ModelFactoryController.getInstance();
		
		comboBoxReserva.getItems().addAll("Habitacion individual+extra", "Habitacion individual"
				, "Habitacion doble", "Habitacion doble+extra");
		
		comboBoxReserva.setOnAction(this::filtrarHabitaciones);
		
		datePickerFechaE.setDayCellFactory(picker -> new DateCellFactory());
		
		datePickerFechaS.setDayCellFactory(picker -> new DateCellFactory());
		
		updateClock(); // Actualizar la hora al cargar la ventana

        // Actualizar la hora cada minuto
        
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
	
	//Procedimiento que filtra que habitaciones están disponibles en el rango de fechas 
	//seleccionadas por el cliente
	private void filtrarHabitaciones(ActionEvent event) {
        String selectedState = comboBoxReserva.getSelectionModel().getSelectedItem();
        
        ObservableList<Integer> habitaciones = FXCollections.observableArrayList();
        
        LocalDate fechaInicio = datePickerFechaE.getValue();
        LocalDate fechaSalida = datePickerFechaS.getValue();

        if (selectedState != null) {
            if (selectedState.equals("Habitacion individual+extra")) {
                	habitaciones.addAll(modelFactoryController.verificarHabitacion(fechaInicio, fechaSalida));
                }
            }if (selectedState.equals("Habitacion individual")) {
            	habitaciones.addAll(modelFactoryController.verificarHabitacion(fechaInicio, fechaSalida));
                	
            }if(selectedState.equals("Habitacion doble")){
            	habitaciones.addAll(modelFactoryController.verificarHabitacion(fechaInicio, fechaSalida));
            	
            	
            }if(selectedState.equals("Habitacion doble+extra")){
            	habitaciones.addAll(modelFactoryController.verificarHabitacion(fechaInicio, fechaSalida));
            	
            }
            comboBoxHabitacion.setItems(habitaciones);
        }

	//Clase que modifica el datePicker para que no se seleccionen fechas anteriores a 
	//la de hoy (en caso de reserva)
	private class DateCellFactory extends javafx.scene.control.DateCell {
        @Override
        public void updateItem(LocalDate item, boolean empty) {
            super.updateItem(item, empty);

            if (item.isBefore(LocalDate.now())) {
                setDisable(true);
                setStyle("-fx-background-color: #ffc0cb;");
            }
        }
    }
	
	public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

		Alert alert = new Alert(alertType);
		alert.setTitle(titulo);
		alert.setHeaderText(header);
		alert.setContentText(contenido);
		alert.showAndWait();
	}
	
	
	


}
