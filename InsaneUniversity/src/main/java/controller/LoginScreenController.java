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

public class LoginScreenController {
	
	private Stage primaryStage;
	
	private LobbyScreenCreator openLobby;
	
	private SignUpScreenController signupscreenController;
	
	private NetworkHandler loginhandler;
	
	private VBox lbox;
	private TextField username;
	private TextField pw;
	private boolean loginErrorMsg = false; 
	
	private void checklogin() {
		//TODO POST request /user/login
		
		loginhandler = new NetworkHandler();
		String name = username.getText();
	    String password = pw.getText();
		
		 //später je nachdem ob erfolgreich oder nicht auf dementsprechenden wert ändern.
	  //200 is http code for OK (return value of NetWorkHandler methods)
		if(loginhandler.login(name, password)==200) {
			enterLobby();
		}
		else {
			//gib fehler login aus
			if(!loginErrorMsg) {
			String errormsg = "Ungültige Logindaten. Versuche es erneut.";
			ObservableList<Node> children = lbox.getChildren();
			Label invalidcr = new Label(errormsg);
			HBox ims = new HBox(invalidcr);
			children.add(ims);
			loginErrorMsg=true;
			}
		}
	}
	
	private void enterLobby() {
		//TODO
		openLobby = new LobbyScreenCreator(loginhandler);
		openLobby.show(this.primaryStage);
	}
	
	
	public void show(Stage primaryStage) {
		// TODO Auto-generated method stub
		this.primaryStage = primaryStage;
	      AnchorPane root = null;
	      try
	      {
	         root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));

	      }
	      catch (IOException e)
	      {
	         e.printStackTrace();
	      }
	      
	      Scene scene = new Scene(root);
	      
	      username = (TextField) scene.lookup("#username");
	      pw = (TextField) scene.lookup("#password");
	      lbox = (VBox) scene.lookup("#loginbox");
	      
	      Button signinButton = (Button) scene.lookup("#signin");

	      signinButton.setOnAction(e -> checklogin());
	      
	      Button signupButton = (Button) scene.lookup("#signup");
	      
	      signupButton.setOnAction(e -> opensignupwindow());
	      
	      Button leaveButton = (Button) scene.lookup("#leave");
	      
	      leaveButton.setOnAction(e -> primaryStage.close());
	      
	      
	      
	      
	      primaryStage.setScene(scene);

	      primaryStage.show();
		
	}

	private void opensignupwindow() {
		// TODO Auto-generated method stub
		
		signupscreenController = new SignUpScreenController();
		signupscreenController.show(this.primaryStage);
		
	}

}
