package controller;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import network.NetworkHandler;

public class SignUpScreenController {
	
	private Stage primaryStage;
	private NetworkHandler signuphandler;
	TextField name;
	
	private VBox sbox;

	private LoginScreenController loginScreen;

	SignUpScreenController(LoginScreenController loginsc){
		this.loginScreen=loginsc;
	}
	 
	
	public void signup() {
		//TODO POST request /user/create
	    String username = name.getText();
		signuphandler = new NetworkHandler();
		//200 is http code for OK (return value of NetWorkHandler methods)
		if(signuphandler.createUser(username)==200) { 
			//geh zurückt zum Login
			loginScreen.show(this.primaryStage);

		}
		else {
			//gib nachricht, dass Registrierung nicht erfolgreich war.
			
			String errormsg = "Ungültiger Username. Versuche es erneut.";
			ObservableList<Node> children = sbox.getChildren();
			Label invalidcr = new Label(errormsg);
			HBox ims = new HBox(invalidcr);
			children.add(ims);
		}
	}

	public void show(Stage primaryStage) {
		// TODO Auto-generated method stub
		
		this.primaryStage = primaryStage;
	      AnchorPane root = null;
	      try
	      {
	         root = FXMLLoader.load(getClass().getResource("SignUpScreen.fxml"));

	      }
	      catch (IOException e)
	      {
	         e.printStackTrace();
	      }
	      
	      Scene scene = new Scene(root);
	      
	      sbox = (VBox) scene.lookup("#signupbox");
	      
	      name = (TextField) scene.lookup("#username");
	      
	      Button signupButton = (Button) scene.lookup("#signup");
	      
	      signupButton.setOnAction(e -> signup());
	      
	      Button leaveButton = (Button) scene.lookup("#leave");
	      
	      leaveButton.setOnAction(e -> primaryStage.close());
	      
	      
	      
	      primaryStage.setScene(scene);

	      primaryStage.show();
		
	}
	

}
