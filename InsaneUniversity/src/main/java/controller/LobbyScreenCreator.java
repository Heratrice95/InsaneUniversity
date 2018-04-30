package controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class LobbyScreenCreator {
	
	
	private Stage primaryStage;

	public void show(Stage primaryStage) {
		// TODO Auto-generated method stub
		
		this.primaryStage = primaryStage;
	      AnchorPane root = null;
	      try
	      {
	         root = FXMLLoader.load(getClass().getResource("LobbyScreen.fxml"));

	      }
	      catch (IOException e)
	      {
	         e.printStackTrace();
	      }
	      
	      Scene scene = new Scene(root);
		
	      primaryStage.setScene(scene);

	      primaryStage.show();
		
		
	}

}
