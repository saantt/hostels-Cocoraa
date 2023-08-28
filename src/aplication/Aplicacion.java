package aplication;

import java.io.IOException;
import java.time.LocalDate;

import controllers.ConfirmacionReservaController;
import controllers.InicioController;
import controllers.LoginRecepcionistaController;
import controllers.PrincipalCliente2Controller;
import controllers.PrincipalCliente3Controller;
import controllers.PrincipalClienteController;
import controllers.PrincipalRecepController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Hotel;



public class Aplicacion extends Application{

	private Stage primaryStage;

	Hotel hotel = new Hotel ("Hostels Cocora", "Cra 30");
	



	@Override
	public void start(Stage primaryStage) {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Hostels Cocora");

		mostrarVentanaIniciar();

	}

	//Procedimiento que muestra la 1ra ventana: inicio del hotel 
	
	public void mostrarVentanaIniciar() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/Inicio.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			InicioController inicioController= loader.getController();
			inicioController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			//primaryStage.setResizable(false);
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Procedimiento que muestra la ventana del login del recepcionista 
	
	public void mostrarVentanaLoginRecepcionista() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/LoginRecepcionista.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			LoginRecepcionistaController loginController = loader.getController();
			loginController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Procedimiento que muestra la ventana principal del recepcionista 
	
	public void mostrarVentanaRecep(String documento) {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/principalRecepcionistaa.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			PrincipalRecepController redPrincipalAdminController = loader.getController();
			redPrincipalAdminController.setAplicacion(this, documento);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Procedimiento que muestra la ventana principal del cliente 
	
	public void mostrarVentanaCliente() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/principalCliente.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			PrincipalClienteController loginController = loader.getController();
			loginController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Procedimiento que muestra la ventana de la confirmaci�n de pago de la reserva (Recepcionista)
	public void mostrarVentanaConfirmacion(LocalDate fechaInicio, LocalDate fechaSalida,
			String habitacion, int numeroReserva, String opcionSeleccionada,String tipoH, int camas, String pago) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/confirmacionReserva.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			ConfirmacionReservaController confirmacionRController = loader.getController();
			confirmacionRController.setAplicacion(this, fechaInicio, fechaSalida, habitacion, numeroReserva, opcionSeleccionada, tipoH, camas,pago);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Procedimiento que muestra la ventana con la informacion de reserva (Cliente)
	public void mostrarVentanaCliente2(LocalDate fechaInicio, LocalDate fechaSalida,
			String habitacion, String tipoH,int camas, String pago) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/principalCliente2.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			PrincipalCliente2Controller loginController = loader.getController();
			loginController.setAplicacion(this,fechaInicio, fechaSalida, habitacion, tipoH,camas,pago);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Procedimiento que muestra la ventana con la confirmacion de la reserva (cliente)
	public void mostrarVentanaCliente3(LocalDate fechaInicio, LocalDate fechaSalida,
			String habitacion, int numeroReserva, String opcionSeleccionada,String tipoH, int camas, String pago) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("../views/principalCliente3.fxml"));

			AnchorPane rootLayout = (AnchorPane)loader.load();

			PrincipalCliente3Controller loginController = loader.getController();
			loginController.setAplicacion(this, fechaInicio, fechaSalida, habitacion, numeroReserva, opcionSeleccionada, tipoH, camas,pago);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//procedimiento main 
	
	public static void main(String[] args) {
		launch(args);
	}
}
