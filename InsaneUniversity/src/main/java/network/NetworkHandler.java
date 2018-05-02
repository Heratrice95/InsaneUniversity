package network;

import org.glassfish.jersey.client.ClientConfig;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.gen.Game;
import model.gen.Player;

import java.net.URI;
import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

public class NetworkHandler {
	private NewCookie cookie;
	private ClientConfig config;
	private Client client;
	private WebTarget target;
	private Player currentPlayer;
	
	public int createUser(String username) {
		//Integer for the HTTP Response Status, later used for testing, always initiated
		//as -1 at the beginning of all the methods so it is no valid response
		int responseStatus = -1;
		JSONParser parser = new JSONParser();
		JSONObject user=null;

		try {
			user = (JSONObject) parser.parse("{\"Username\":\""+ username +"\"}");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Response response = target.path("user").path("create").request().post(Entity.entity(user, MediaType.APPLICATION_JSON),Response.class);
		responseStatus = response.getStatus();
		
		return responseStatus;
	}
	
	public int login(String username, String password) {
		int responseStatus = -1;
		JSONParser parser = new JSONParser();
		JSONObject user = null;
	
		try {
			user = (JSONObject) parser.parse("{\"Username\":\""+username+"\", \"Password\":\""+password+"\"}");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Response response = target.path("user").path("login").request()
				.post(Entity.entity(user, MediaType.APPLICATION_JSON), Response.class);
		
		responseStatus = response.getStatus();
		this.cookie = response.getCookies().get("JSESSIONID");
		
		this.currentPlayer = new Player().withName(username);
		
		return responseStatus;
	}
	
	public int getUserStatus() {
		int responseStatus = -1;
		
		Response response = target.path("user").path("info").request().cookie(this.cookie).get(Response.class);
		responseStatus = response.getStatus();
		
		return responseStatus;
	}
	
	public int createGame(String gamename) {
		int responseStatus = -1;
//		Not JSON Stuff not needed here
		ArrayList<Game> checkList = this.getGamesFromServer();
		
		for(Game check : checkList) {
			if(check.getName().equals(gamename)) {
				// Return 400 for bad request because a game with this name already exists
				return 400; 
			}
		}
		
		JSONObject game = new JSONObject();
		game.put("name", gamename);
		
		// Is it right to create it as header (org.apache.http.header)?
		Response response = target.path("api").path("games").path("create").request().cookie(this.cookie).header("name", gamename).post(Entity.entity(game, MediaType.APPLICATION_JSON), Response.class);
							
		
		responseStatus = response.getStatus();
		
		return responseStatus;
	}
	
	public int logout() {
		int responseStatus = -1;
		Response response = target.path("user").path("logout").request().cookie(this.cookie).get(Response.class);
		responseStatus = response.getStatus();
		
		return responseStatus;
	}
	
	public ArrayList<Game> getGamesFromServer(){
		ArrayList<Game> games = new ArrayList<Game>();
		JSONParser parser = new JSONParser();
		JSONObject game=new JSONObject();

		String response = target.path("api").path("games").
							request().
							cookie(cookie).accept(MediaType.APPLICATION_JSON).get(String.class);
		
		try {
			JSONArray gamesArray = (JSONArray) parser.parse(response);
			//Get objects from JSONArray
			for(Object obj:gamesArray) {
				//Cast current object to JSONObject
				JSONObject jobj = (JSONObject) obj;
				JSONObject prop = (JSONObject) jobj.get("prop");
				String name = (String) prop.get("name");
				//String session = (String) prop.get("session"); //evtl. später benötigt
				games.add(new Game().withName(name));
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return games;
	}

	
	public ArrayList<Player> getPlayersFromServer(){
		ArrayList<Player> players = new ArrayList<Player>();
		JSONParser parser = new JSONParser();
		JSONObject user=null;

		String response = target.path("api").path("players").
							request().
							cookie(cookie).accept(MediaType.APPLICATION_JSON).get(String.class);

		try {
			JSONArray playerArray = (JSONArray) parser.parse(response);
			//Get objects from JSONArray
			for(Object obj:playerArray) {
				//Cast current object to JSONObject
				JSONObject jobj = (JSONObject) obj;
				JSONObject prop = (JSONObject) jobj.get("prop");
				String name = (String) prop.get("name");
				//String session = (String) prop.get("session"); //evtl. später benötigt
				players.add(new Player().withName(name));
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return players;
	}
	
	// Help method for checking if the user is (still) logged in, returns 200 if logged in
	//TODO: is it really needed? Could maybe be removed
	public int cookiestillactive() {
		int responseStatus = -1;
		Response response = target.path("user").path("info").request().cookie(this.cookie).get(Response.class);
		responseStatus = response.getStatus();
		
		return responseStatus;
	}
	
	
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://avocado.uniks.de:33000").build();
	}
	
	public NetworkHandler(){
		this.config = new ClientConfig();
		
		this.client = ClientBuilder.newClient(config);
		
		this.target = this.client.target(getBaseURI());
	}

	public Player getCurrentPlayer(){
		return this.currentPlayer;
	}

}
