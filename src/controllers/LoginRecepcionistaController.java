package controllers;
import java.net.URL;
import java.util.ResourceBundle;

import aplication.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;

public class LoginRecepcionistaController {
	
	//Atributos del controlador
	
	  @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private Button btnIngresar;

	    @FXML
	    private PasswordField txtContraseniaAdmin;

	    @FXML
	    private TextField txtNumDocumentoAdmin;
	    
	    private Aplicacion aplicacion; 
	    
	    ModelFactoryController modelFactoryController; 
	    
	    @FXML
	    private ImageView flechaRegresar;

	    //Evento de la flecha para volver a la ventana anterior
	    @FXML
	    void flechaEvent(MouseEvent event) {
	    	flechaRegresar.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent ->{
	    		aplicacion.mostrarVentanaIniciar();
	    	});

	    }

	   // Evento del boton ingresar del login
	    @FXML
	    void ingresarEvent(ActionEvent event) {
	    	ingresarAction();
	    }
	    
	    //Procedimiento donde se toman los datos, se verifican y dan paso para abrir la ventana 
	    //principal del recepcionista
	    
	    private void ingresarAction() {

	    	String documentoRecep = "";
	    	String contraseniaRecep = "";

	    	documentoRecep = txtNumDocumentoAdmin.getText();
	    	contraseniaRecep = txtContraseniaAdmin.getText();

	    	if(datosValidos(documentoRecep,contraseniaRecep)){

	    		boolean documentoValido = modelFactoryController.verificarRecepcionista(documentoRecep,contraseniaRecep);
	    		if(documentoValido){
	    			aplicacion.mostrarVentanaRecep(documentoRecep);
	    		}else{
	    			mostrarMensaje("Notificacion Inicio sesion", "Recepcionista no existe", "Los datos ingresados no corresponde a un recepcionista valido", AlertType.INFORMATION);

	    		}
	    	}else{
				mostrarMensaje("Notificacion Inicio sesion", "Datos Incompletos", "Debe ingresar los datos correctamente, despues de 3 intentos se bloqueara el usuario", AlertType.WARNING);

	    	}

		}
	    
	    public void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {

			Alert alert = new Alert(alertType);
			alert.setTitle(titulo);
			alert.setHeaderText(header);
			alert.setContentText(contenido);
			alert.showAndWait();
		}

		private boolean datosValidos(String usuario, String contrasenia) {
			if(usuario.equals("") || contrasenia.equals("")){
				return false;
			}
			return true;
		}
		
		 @FXML
		    void initialize() {
		    	modelFactoryController = ModelFactoryController.getInstance();

		    }
		 
		 public void setAplicacion(Aplicacion aplicacion) {
				this.aplicacion = aplicacion;

			}
		    


}
