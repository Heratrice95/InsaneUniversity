package networkTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.gen.Player;
import network.NetworkHandler;

public class NetworkTest {

	@Test
	public void test() {
		
		boolean playersExist = false;
		NetworkHandler test = new NetworkHandler();
		test.login("Thor", "crazy");
		
		ArrayList<Player> playerList = test.getPlayersFromServer();
		ArrayList<String> nameList = new ArrayList<String>();
		
		for(int i = 0; i<playerList.size(); i++) {
//			System.out.println(player.getName());
			nameList.add(playerList.get(i).getName());
		}
		
		if(nameList.contains("Thor")) {
			playersExist = true;
		}
		assertTrue("Thor is not in the list", playersExist);
		
	}
	@Test
	public void logoutTest() {
		
		NetworkHandler test2 = new NetworkHandler();
		test2.login("Thor", "crazy");
		test2.logout();
		boolean a = test2.cookiestillactive();
		assertFalse(a);
		
	}

}
