package network;

import org.glassfish.jersey.client.ClientConfig;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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

//TODO: return status int (or the whole response) so the methods can be tested better
public class NetworkHandler {
	int responseStatus;	//Integer for the HTTP Response Status, later used for testing, initiated 
						//as -1 at the beginning of all the methods so it is no valid response
	private NewCookie cookie;
	private ClientConfig config;
	private Client client;
	private WebTarget target;
	
	public int createUser(String username) {
		responseStatus = -1;
		JSONParser parser = new JSONParser();
		JSONObject user=null;

		try {
			user = (JSONObject) parser.parse("{\"Username\":\""+ username +"\"}");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Response response = target.path("user").path("create").request().post(Entity.entity(user, MediaType.APPLICATION_JSON),Response.class);
		responseStatus = response.getStatus();
		
		System.out.println(response.toString());
		
		return responseStatus;
	}
	
	public int login(String username, String password) {
		responseStatus = -1;
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
		
		System.out.println(response.toString());
		
		return responseStatus;
	}
	
	// TODO Change return value to int here as well?
	public int logout() {
		responseStatus = -1;
		Response response = target.path("user").path("logout").request().cookie(this.cookie).get(Response.class);
		responseStatus = response.getStatus();
		
		return responseStatus;
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
	//TODO: is it really needed?
	public int cookiestillactive() {
		responseStatus = -1;
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

}
