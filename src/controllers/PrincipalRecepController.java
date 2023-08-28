 package controllers;
import java.time.LocalDate;
import java.util.Random;

import javax.swing.JOptionPane;

import aplication.Aplicacion;
import exceptions.ClienteException;
import exceptions.ReservaException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.Cama;
import model.Cliente;
import model.Estado;
import model.Habitacion;
import model.Reserva;

public class PrincipalRecepController {
	
	//Atributos del controlador
	
	private Aplicacion aplicacion; 
	
	private String documento;
	
	ModelFactoryController modelFactoryController;
	
	@FXML
    private Button btnRegresar;
	
	 @FXML
	    void regresarEvent(ActionEvent event) {
		 
		 aplicacion.mostrarVentanaIniciar();

	    }
    
    //------------------------------------------------------------
    
    //TAP DE HABITACIONES
    
    @FXML
    private DatePicker datePicker;
    
    @FXML
    private TableView<Habitacion> tableHabitaciones;
    
    @FXML
    private Label labelTipoH;

    @FXML
    private Label labelNroCamas;

    @FXML
    private Label labelEstado;

    @FXML
    private Label labelSituacion;

    @FXML
    private ComboBox<Estado> comboBox;

    @FXML
    private Button btnA;

    @FXML
    private TableColumn<Habitacion, Integer> columnNumeroH;
    
    Habitacion habitacionSeleccionada;

    ObservableList<Habitacion> listaHabitacionesData = FXCollections.observableArrayList();
    
    @FXML
    void aEvent(ActionEvent event) {
    	Estado selectedItem = comboBox.getSelectionModel().getSelectedItem();
        habitacionSeleccionada.setEstadoHabitacion(selectedItem);
        labelEstado.setText(habitacionSeleccionada.getEstadoHabitacion().toString());
        tableHabitaciones.refresh();
        comboBox.setValue(null);
    }
    
    private ObservableList<Habitacion> getListaHabitacionesData(){
		listaHabitacionesData.addAll(modelFactoryController.obtenerHabitaciones());
		return listaHabitacionesData;
	}
    
    private void mostrarInformacionHabitacion(Habitacion habitacionSeleccionada) {
		labelTipoH.setText(habitacionSeleccionada.getTipoHabitacion().toString());
		labelEstado.setText(habitacionSeleccionada.getEstadoHabitacion().toString());
		labelSituacion.setText(habitacionSeleccionada.getSituacion().toString());
		if(habitacionSeleccionada.getListCamas()!= null){
			labelNroCamas.setText(Integer.toString(habitacionSeleccionada.getListCamas().size()));
		}else{
			labelNroCamas.setText("0");
		}
	}
    
    //---------------------------------------------------------
    
    //TAP DE CAMAS 
    
    @FXML
    private DatePicker datepickerC;

    @FXML
    private TableView<Cama> tableCamas;

    @FXML
    private TableColumn<Cama, String> columnNumeroC;

    @FXML
    private Label labelEstadoC;

    @FXML
    private Label labelTipoC;

    @FXML
    private Label labelNroHabitacion;

    @FXML
    private Label labelSituacionC;

    @FXML
    private ComboBox<Estado> comboBoxCamas;

    @FXML
    private Button btnCambiarEstado;
    
    Cama camaSeleccionada;

    ObservableList<Cama> listaCamasData = FXCollections.observableArrayList();
    
    @FXML
    void cambiarEstadoEvent(ActionEvent event) {
    	Estado selectedItem = comboBoxCamas.getSelectionModel().getSelectedItem();
        camaSeleccionada.setEstadoCama(selectedItem);
        labelEstadoC.setText(camaSeleccionada.getEstadoCama().toString());
        tableCamas.refresh();
        comboBoxCamas.setValue(null);
    }
    
    private ObservableList<Cama> getListaCamasData(){
		listaCamasData.addAll(modelFactoryController.obtenerCamas());
		return listaCamasData;
	}
    
    private void mostrarInformacionCama(Cama camaSeleccionada) {
		labelTipoC.setText(camaSeleccionada.getTipoCama().toString());
		labelEstadoC.setText(camaSeleccionada.getEstadoCama().toString());
		labelSituacionC.setText(camaSeleccionada.getSituacionCama().toString());
		labelNroHabitacion.setText(modelFactoryController.devolverNroH(camaSeleccionada.getNroCama()));
	}
    
    
    //-----------------------------------------
    
    //TAP RESERVAS
    
    @FXML
    private DatePicker datePickerVerificarH;

    @FXML
    private DatePicker datePickerVerificarC;

    @FXML
    private DatePicker datePickerFechaE;

    @FXML
    private DatePicker datePickerFechaS;

    @FXML
    private ComboBox<String> comboBoxReserva;

    @FXML
    private Label labelDisponibilidadCD;

    @FXML
    private Label labelDisponibilidadIC;

    @FXML
    private Label labelDisponibilidadD;

    @FXML
    private Label labelDisponibilidadI;

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
    private Button btnReservar;
    
    @FXML
    private ComboBox<Integer> comboBoxHabitacion;
    
    @FXML
    void ReservarEvent(ActionEvent event) {
    	reservarAction();
    }
    
    private void reservarAction() {
    	LocalDate fechaInicio = datePickerFechaE.getValue();
        LocalDate fechaSalida = datePickerFechaS.getValue();
        String habitacion= Integer.toString(comboBoxHabitacion.getSelectionModel().getSelectedItem());
        String tipoH = comboBoxReserva.getSelectionModel().getSelectedItem();
		String nombre= JOptionPane.showInputDialog("Ingrese su nombre para continuar con la reserva");
		String cedula= JOptionPane.showInputDialog("Ingrese su cedula para continuar con la reserva");
		int camas= modelFactoryController.devolverNroCamas(habitacion);
		String pago= Integer.toString(modelFactoryController.calcularPago(tipoH));
		Random random = new Random();
        int numeroReserva = 100000 + random.nextInt(900000);
        String opcionSeleccionada= "";
		String [] botones = { "Recepcion", "Tarjeta Debito/Credito", "PSE"};
		int variable = JOptionPane.showOptionDialog (null, "�Por qu� medio desea realizar su pago?", "Metodos de pago", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);
		if (variable >= 0 && variable < botones.length) {
            opcionSeleccionada = botones[variable];
		}
		crearReservaCliente(fechaInicio, fechaSalida, numeroReserva, habitacion, nombre, cedula, opcionSeleccionada,tipoH, camas, pago);
		
		
	}
    
    private void crearReservaCliente(LocalDate fechaInicio, LocalDate fechaSalida, int numeroReserva,
    		String habitacion, String nombre, String cedula,String opcionSeleccionada,String tipoH, int camas,
    		String pago){
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
		 	aplicacion.mostrarVentanaConfirmacion(fechaInicio, fechaSalida, habitacion, numeroReserva, opcionSeleccionada, tipoH,camas, pago);
		} catch (ReservaException e) {

			mostrarMensaje("Notificacion reserva", "Reserva invalida", "Hubo un error al realizar la reserva", AlertType.ERROR);
		}
		
		
    	
    }

	private void verificarDisponibilidad() {
        LocalDate fechaSeleccionadaH = datePickerVerificarH.getValue();
        if (fechaSeleccionadaH != null) {
            String mensaje = modelFactoryController.verificarDisponibilidad(fechaSeleccionadaH);
            String mensaje2= modelFactoryController.verificarDisponibilidad2(fechaSeleccionadaH);
            mostrarInformacionDisponibilidad(mensaje, mensaje2);
        }
    }
    
    private void mostrarInformacionDisponibilidad(String mensaje, String mensaje2) {
		labelDisponibilidadD.setText(mensaje);
		labelDisponibilidadI.setText(mensaje2);
	}
    
    private void verificarDisponibilidadC(){
    	  LocalDate fechaSeleccionadaC = datePickerVerificarC.getValue();
          if (fechaSeleccionadaC != null) {
              String mensaje = modelFactoryController.verificarDisponibilidadC1(fechaSeleccionadaC);
              String mensaje2= modelFactoryController.verificarDisponibilidadC2(fechaSeleccionadaC);
              mostrarInformacionDisponibilidadC(mensaje, mensaje2);
          }
    }
    
    private void mostrarInformacionDisponibilidadC(String mensaje, String mensaje2){
    	labelDisponibilidadCD.setText(mensaje);
    	labelDisponibilidadIC.setText(mensaje2);
    }
    
    private void mostrarInformacionReserva(){
    	LocalDate fechaInicio = datePickerFechaE.getValue();
        LocalDate fechaSalida = datePickerFechaS.getValue();
        String selectedState = comboBoxReserva.getSelectionModel().getSelectedItem();
        String selectedState2 = Integer.toString(comboBoxHabitacion.getSelectionModel().getSelectedItem());
        int camas= modelFactoryController.devolverNroCamas(selectedState2);
        
        labelFechaIngreso.setText(fechaInicio.toString());
        labelFechaSalida.setText(fechaSalida.toString());
        labelNumeroHReserva.setText(selectedState2);
        labelTipoHReserva.setText(selectedState);
        labelNroCamasReserva.setText(Integer.toString(camas));
        labelTotalReserva.setText(Integer.toString(modelFactoryController.calcularPago(selectedState)));
    }

    
    
    //-----------------------------------
    //TAP CLIENTES
    
    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtCorreo;

    @FXML
    private Button btnCrearCliente;

    @FXML
    private TextField txtBuscarCliente;
    
    @FXML
    void buscarEvent(KeyEvent event) {
    	txtBuscarCliente.addEventHandler(KeyEvent.KEY_RELEASED, keyEvent ->{
            if(event.getCode() == KeyCode.ENTER){
            	obtenerClienteRegistro();
            }
	    	});
    }
    
    private void obtenerClienteRegistro() {
    	String nombre= txtBuscarCliente.getText(); 
		if(datoValido(nombre)==true){
			if(modelFactoryController.obtenerInformacion(nombre)==true){
				mostrarMensaje("Notificacion Busqueda", "Cliente encontrado", "El cliente ya tiene una reservaci�n registrada", AlertType.ERROR);
			}else{
				mostrarMensaje("Notificacion Busqueda", "Cliente no encontrado", "El nombre no esta relacionado a ningun cliente registrado en el hotel", AlertType.ERROR);
			}
		}
		else{
			mostrarMensaje("Notificacion Busqueda", "datos invalidos", "Debe escribir un nombre para poder buscar en el registro del hotel", AlertType.ERROR);
		}
	}
    
    private boolean datoValido(String nombre){
		if(nombre.equals("")){
			return false;
		}
		return true;
		
	}


	@FXML
    void crearClienteEvent(ActionEvent event) {
		crearClienteAction();
		txtNombre.setText("");
		txtCedula.setText("");
		txtTelefono.setText("");
		txtCorreo.setText("");

    }
    
    private void crearClienteAction() {
    	String nombre = txtNombre.getText();
    	String documento = txtCedula.getText();
    	String telefono = txtTelefono.getText();
    	String correo = txtCorreo.getText();
    	
    	if(datosValidos(nombre,documento, telefono, correo) == true){

    		Cliente cliente = null;
    		try {
				cliente=modelFactoryController.registrarCliente(nombre, documento, telefono, correo);
				mostrarMensaje("Notificacion registro", "Cliente registrado", "Se ha registrado con exito en Hostels Cocora", AlertType.INFORMATION);
			} catch (ClienteException e) {

				mostrarMensaje("Notificacion registro", "Cliente no registrado", "Ya se ha registrado un cliente con identificacion"+documento+".", AlertType.ERROR);
			}
    	}
    		else{
    			mostrarMensaje("Notificacion registro", "Informacion invalida", "Informacion invalida", AlertType.ERROR);

    		}
    	modelFactoryController.guardarResourceXML();
    	}
		
	private boolean datosValidos(String nombre, String apellido, String documento, String direccion) {
		if(nombre.equals("")){
			return false;
		}
		if(apellido.equals("")){
			return false;
		}
		if(documento.equals("")){
			return false;
		}
		if(direccion.equals("")){
			return false;
		}

		
		return true;
		
    }

	//-------------------------------------------------

    
    //-------------------------------------
    
    
    //SET APLICACION E INICIALIZAR
	
	public void setAplicacion(Aplicacion aplicacion, String documento) {
		this.aplicacion = aplicacion;
		this.documento = documento; 
		tableHabitaciones.getItems().clear();
		tableHabitaciones.setItems(getListaHabitacionesData());
		tableCamas.getItems().clear();
		tableCamas.setItems(getListaCamasData());
		
	 	
	}
	
	
	@FXML
    void initialize() {
		modelFactoryController = ModelFactoryController.getInstance();
		
		comboBox.getItems().addAll(Estado.MANTENIMIENTO, Estado.EN_OPERACION);
		
		comboBoxCamas.getItems().addAll(Estado.MANTENIMIENTO, Estado.EN_OPERACION);
		
		comboBoxReserva.getItems().addAll("Habitacion individual+extra", "Habitacion individual"
				, "Habitacion doble", "Habitacion doble+extra");
		comboBoxReserva.setOnAction(this::filtrarHabitaciones);
		
		datePickerFechaE.setDayCellFactory(picker -> new DateCellFactory());
		
		datePickerFechaS.setDayCellFactory(picker -> new DateCellFactory());
		
		//Columna de habitaciones de la tabla Habitaciones
		
		this.columnNumeroH.setCellValueFactory(new PropertyValueFactory<>("numeroHabitacion"));

	   	tableHabitaciones.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

	   		habitacionSeleccionada = newSelection;
	   		
	   		LocalDate fechaSeleccionada = datePicker.getValue();

	        if (fechaSeleccionada != null && habitacionSeleccionada != null) {
	        	modelFactoryController.verificarEstado(fechaSeleccionada, habitacionSeleccionada.getNumeroHabitacion());
	        	mostrarInformacionHabitacion(habitacionSeleccionada);	
	        }		
	   	});
	   	
	   	//Columna de camas de la tabla Camas
	   	
	   	this.columnNumeroC.setCellValueFactory(new PropertyValueFactory<>("nroCama"));

	   	tableCamas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

	   		camaSeleccionada = newSelection;
	   		
	   		LocalDate fechaSeleccionada = datepickerC.getValue();

	        if (fechaSeleccionada != null && camaSeleccionada != null) {
	        	modelFactoryController.verificarEstadoCama(fechaSeleccionada, camaSeleccionada.getNroCama());
	        	mostrarInformacionCama(camaSeleccionada);	
	        }		
	   	});
	   	
	    datePickerVerificarH.setOnAction(event -> verificarDisponibilidad());
	    datePickerVerificarC.setOnAction(event -> verificarDisponibilidadC());
	    comboBoxHabitacion.setOnAction(event -> {
	        Integer selectedHabitacion = comboBoxHabitacion.getSelectionModel().getSelectedItem();
	        if (selectedHabitacion != null) {
	            mostrarInformacionReserva();
	        }
	    });
	   	
	   	
	}
	//Metodo que filtra que habitaciones est�n disponibles en un rango de fechas
	//seleccionadas por el recepcionista 
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

	//Clase que modifica el calendario para que no se seleccionen fechas anteriores a
	//la actual
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
