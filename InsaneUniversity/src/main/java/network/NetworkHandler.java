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


public class NetworkHandler {
	private NewCookie cookie;
	private ClientConfig config;
	private Client client;
	private WebTarget target;
	
	public boolean createUser(String username) {
		
		JSONParser parser = new JSONParser();
		JSONObject user=null;

		try {
			user = (JSONObject) parser.parse("{\"Username\":\""+ username +"\"}");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Response response = target.path("user").path("create").request().post(Entity.entity(user, MediaType.APPLICATION_JSON),Response.class);
		System.out.println(response.toString());
		if(response.getStatus()==200) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean login(String username, String password) {
		JSONParser parser = new JSONParser();
		JSONObject user = null;
	
		try {
			user = (JSONObject) parser.parse("{\"Username\":\""+username+"\", \"Password\":\""+password+"\"}");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Response response = target.path("user").path("login").request()
				.post(Entity.entity(user, MediaType.APPLICATION_JSON), Response.class);
		
		this.cookie = response.getCookies().get("JSESSIONID");
		
		System.out.println(response.toString());
		if (response.getStatus() == 200) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public boolean logout() {
		Response response = target.path("user").path("logout").request().cookie(this.cookie).get(Response.class);
		
		if(response.getStatus()==200) {
			return true;
		}
		return false;
	}
	
	public boolean cookiestillactive() {
		Response response = target.path("user").path("info").request().cookie(this.cookie).get(Response.class);
		if(response.getStatus()==200) {
			return true;
		}
		return false;
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
			for(Object obj:playerArray) {
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
	
	
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://avocado.uniks.de:33000").build();
	}
	
	public NetworkHandler(){
		this.config = new ClientConfig();
		
		this.client = ClientBuilder.newClient(config);
		
		this.target = this.client.target(getBaseURI());
	}

}
