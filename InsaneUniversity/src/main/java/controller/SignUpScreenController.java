package controller;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SignUpScreenController {
	
	private Stage primaryStage;
	private LobbyScreenCreator openLobby;
	
	
	public void signup(String username) {
		//TODO POST request /user/create
		boolean successfull= true;
		if(successfull) {
			//betritt lobby
			openLobby = new LobbyScreenCreator();
			openLobby.show(this.primaryStage);
		}
		else {
			//gib nachricht, dass Registrierung nicht erfolgreich war.
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
	      
	      TextField name = (TextField) scene.lookup("#username");
	      String username = name.getText();
	      
	      Button signupButton = (Button) scene.lookup("#signup");
	      
	      signupButton.setOnAction(e -> signup(username));
	      
	      Button leaveButton = (Button) scene.lookup("#leave");
	      
	      leaveButton.setOnAction(e -> primaryStage.close());
	      
	      
	      primaryStage.setScene(scene);

	      primaryStage.show();
		
	}
	

}
