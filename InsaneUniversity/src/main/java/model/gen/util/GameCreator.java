package model.gen.util;
import de.uniks.networkparser.interfaces.SendableEntityCreator;
import model.gen.Game;
import model.gen.Player;
import model.gen.Lobby;


public class GameCreator implements SendableEntityCreator
{

   private final String[] properties = new String[]
   {
      Game.PROPERTY_PLAYERS,
      Game.PROPERTY_LOBBY,
      Game.PROPERTY_MAXPLAYERS,
      Game.PROPERTY_NAME,
   };

   @Override
   public String[] getProperties()
   {
      return properties;
   }

   @Override
   public Object getSendableInstance(boolean prototyp)
   {
      return new Game();
   }

   @Override
   public Object getValue(Object entity, String attribute)
   {
      int pos = attribute.indexOf('.');
      String attrName = attribute;

      if (pos > 0)
      {
         attrName = attribute.substring(0, pos);
      }
      if(attrName.length()<1) {
         return null;
      }

      if (Game.PROPERTY_PLAYERS.equalsIgnoreCase(attrName))
      {
         return ((Game) entity).getPlayers();
      }

      if (Game.PROPERTY_LOBBY.equalsIgnoreCase(attrName))
      {
         return ((Game) entity).getLobby();
      }

      if (Game.PROPERTY_MAXPLAYERS.equalsIgnoreCase(attrName))
      {
         return ((Game) entity).getMaxPlayers();
      }

      if (Game.PROPERTY_NAME.equalsIgnoreCase(attrName))
      {
         return ((Game) entity).getName();
      }

      return null;
   }

   @Override
   public boolean setValue(Object entity, String attribute, Object value, String type)
   {
      if (SendableEntityCreator.REMOVE.equals(type) && value != null)
      {
         attribute = attribute + type;
      }

      if (Game.PROPERTY_PLAYERS.equalsIgnoreCase(attribute))
      {
         ((Game) entity).withPlayers((Player) value);
         return true;
      }

      if (Game.PROPERTY_LOBBY.equalsIgnoreCase(attribute))
      {
         ((Game) entity).setLobby((Lobby) value);
         return true;
      }

      if (Game.PROPERTY_MAXPLAYERS.equalsIgnoreCase(attribute))
      {
         ((Game) entity).setMaxPlayers((int) value);
         return true;
      }

      if (Game.PROPERTY_NAME.equalsIgnoreCase(attribute))
      {
         ((Game) entity).setName((String) value);
         return true;
      }

      return false;
   }

}