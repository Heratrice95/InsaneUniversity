package model.gen;

import static org.junit.Assert.*;

import org.junit.Test;

import de.uniks.networkparser.ext.ClassModel;
import de.uniks.networkparser.graph.Cardinality;
import de.uniks.networkparser.graph.Clazz;
import de.uniks.networkparser.graph.DataType;

public class ModelGen {

	@Test
	public void modelGen() {
		
		ClassModel cm = new ClassModel("model.gen");
		
		//Classes
		Clazz player = cm.createClazz("Player");
		Clazz game = cm.createClazz("Game");
		Clazz account = cm.createClazz("Account");
		Clazz lobby = cm.createClazz("Lobby");
		Clazz message = cm.createClazz("Message");
		
		//Associations
		player.withBidirectional(game, "game", Cardinality.ONE, "players", Cardinality.MANY);
		lobby.withBidirectional(game, "games", Cardinality.MANY, "lobby", Cardinality.ONE);
		account.withBidirectional(lobby, "lobby", Cardinality.ONE, "account", Cardinality.ONE);
		player.withBidirectional(account, "account", Cardinality.ONE, "player", Cardinality.ONE);
		message.withBidirectional(player, "player", Cardinality.ONE,"messages", Cardinality.MANY);
		
		//Attributes
		player.withAttribute("name", DataType.STRING);
		player.withAttribute("color", DataType.STRING);
		
		account.withAttribute("username", DataType.STRING);
		account.withAttribute("password", DataType.STRING);
		
		message.withAttribute("message", DataType.STRING);
		
		game.withAttribute("name", DataType.STRING);
		game.withAttribute("maxPlayers", DataType.INT);
		
		lobby.withAttribute("name", DataType.STRING);
		
		
		cm.generate("src/main/java");
	}

}
