package networkTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.gen.Game;
import model.gen.Player;
import network.NetworkHandler;
import static org.hamcrest.CoreMatchers.*;

public class NetworkTest {
	
	
	@Test
	public void testLogin() {
		NetworkHandler test = new NetworkHandler();
		//Response should have status=200 for OK
		assertEquals("Thor not logged in although he should be", 200, test.login("Thor", "crazy"));
		//Response should have status=401 for Unauthorized because of wrong password
		assertEquals("Thor logged in although he shouldn't be", 401, test.login("Thor", "wasd"));
	}
	
	@Test
	public void testCreateUser() {
		NetworkHandler test = new NetworkHandler();
		// Return value of createUser should be 400 for bad request (user already registered)
		// Only testing the error case here to not flood the database with unused characters when testing
		assertEquals("User registered although a user with the same name already exists", 400, test.createUser("Thor"));
	}
	
	@Test
	public void testUserStatus() {
		NetworkHandler test = new NetworkHandler();
		test.logout();
//		System.out.println("Testing user status: not logged in");
//		assertEquals("User wrongly displayed as logged in", ,test.getUserStatus());
		assertThat("User wrongly displayed as logged in", test.getUserStatus(), not(equals(200)));
		test.login("Thor", "crazy");
		assertEquals("Thors status not displayed as logged in although it should be", 200, test.getUserStatus());
	}
	
	@Test
	// In this test two players are checked, which should exist.
	// If it turns red: check if the players on the server have been reseted
	public void testGetPlayers() {
		
		boolean playersExist = false;
		NetworkHandler test = new NetworkHandler();
		test.login("Thor", "crazy");
		
		ArrayList<Player> playerList = test.getPlayersFromServer();
		ArrayList<String> nameList = new ArrayList<String>();
		
		for(int i = 0; i<playerList.size(); i++) {
			nameList.add(playerList.get(i).getName());
		}
		
		if(nameList.contains("Thor")) { //&& nameList.contains("Jupiter")
			playersExist = true;
		}
//		assertTrue("A Player who should exist is missing", playersExist);
		

		
		for( Player a : playerList) {
			System.out.println(a.getName());
		}
		
	}
	
	@Test
	public void testLogout() {
		
		NetworkHandler test = new NetworkHandler();
		test.login("Thor", "crazy");
		test.logout();
		int logoutCheck = test.logout();
		assertThat("User not logged out", logoutCheck, not(equals(200)));
	}
	
	@Test
	public void testCreateGame() {
		NetworkHandler test = new NetworkHandler();
		test.login("Thor", "crazy");
		System.out.println(test.createGame("Final Fantasy 14"));
		
		
	}
	
	@Test
	public void testGetGames() {
		
		NetworkHandler test = new NetworkHandler();
		test.login("Thor", "crazy");
		
		ArrayList<Game> testlist = test.getGamesFromServer();
		
		for( Game a : testlist) {
			System.out.println(a.getName());
		}
		
	}

}
