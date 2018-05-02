package controller;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.gen.Game;
import model.gen.Player;
import network.NetworkHandler;


public class LobbyScreenCreator {

	private NetworkHandler handleData;

	private VBox gamebox;
	private VBox playerbox;


	private Stage primaryStage;

	LobbyScreenCreator(NetworkHandler handler){

		this.handleData=handler;
	}


	public void loadGames(){

        ArrayList<Game> games = handleData.getGamesFromServer();
        ObservableList<Node> children = gamebox.getChildren();

        for(Game game: games){
            Label name = new Label(game.getName());
            HBox h1 = new HBox(name);
            children.add(h1);
        }
	}

	public void loadPlayers(){

		ArrayList<Player> players = handleData.getPlayersFromServer();
		ObservableList<Node> children = playerbox.getChildren();

		for(Player player: players){
			Label name = new Label(player.getName());
			HBox h1 = new HBox(name);
			children.add(h1);
		}
	}

	public void createGame(String game){


    }

    public void logout(){

	    handleData.logout();
	    primaryStage.close();

        LoginScreenController loginScreenController =  new LoginScreenController();
        loginScreenController.show(primaryStage);
    }


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
	      gamebox = (VBox) scene.lookup("#gamebox");
	      playerbox = (VBox) scene.lookup("#playerbox");
	      HBox currentPlayer = (HBox) scene.lookup("#currentplayer");
	      Label playerlabel = new Label("Logged in as: " + handleData.getCurrentPlayer().getName());
	      ObservableList<Node> children = currentPlayer.getChildren();
	      children.add(playerlabel);

	      Button logout = (Button) scene.lookup("#logout");
	      logout.setOnAction(e -> logout());

	      loadPlayers();
	      loadGames();


		
	      primaryStage.setScene(scene);

	      primaryStage.show();
		
	}

}
