package controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginScreenController {
	
	private Stage primaryStage;
	
	private LobbyScreenCreator openLobby;
	
	private SignUpScreenController signupscreenController;
	
	
	
	
	
	private void checklogin(String uname, String pw) {
		//TODO POST request /user/login
		
		boolean loginsuccessfull = true; //später je nachdem ob erfolgreich oder nicht auf dementsprechenden wert ändern.
		if(loginsuccessfull) {
			enterLobby();
		}
		else {
			//gib fehler login aus
		}
	}
	
	private void enterLobby() {
		//TODO
		openLobby = new LobbyScreenCreator();
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
	      
	      TextField username = (TextField) scene.lookup("#username");
	      TextField pw = (TextField) scene.lookup("#password");
	      
	      Button signinButton = (Button) scene.lookup("#signin");
	      
	      String name = username.getText();
	      String password = pw.getText();

	      signinButton.setOnAction(e -> checklogin(name, password));
	      
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
