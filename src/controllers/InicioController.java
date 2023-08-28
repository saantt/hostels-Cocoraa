package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import aplication.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class InicioController {
	
	//Atributos del controlador 
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnIngresarRecepcionista;

    @FXML
    private ImageView ayuda;

    @FXML
    private Button btnIngresarCliente;
    
    private Aplicacion aplicacion; 

    //Evento del icono de ayuda
    @FXML
    void ayudaEvent(MouseEvent event) {
    	ayuda.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent ->{
    		JOptionPane.showMessageDialog(null, "hola", null, JOptionPane.INFORMATION_MESSAGE);
    	});
    }
    
    //Evento del boton ingresar (cliente)

    @FXML
    void ingresarClienteEvent(ActionEvent event) {
    	aplicacion.mostrarVentanaCliente();
    }
    
    //Evento del boton ingresar (recepcionista)
    @FXML
    void ingresarRecepcionistaEvent(ActionEvent event) {
    	aplicacion.mostrarVentanaLoginRecepcionista();
    }
    
    public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;

	}
    
	
   
}
   

    