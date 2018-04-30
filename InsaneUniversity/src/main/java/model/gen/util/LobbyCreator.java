package model.gen.util;
import de.uniks.networkparser.interfaces.SendableEntityCreator;
import model.gen.Lobby;
import model.gen.Game;
import model.gen.Account;


public class LobbyCreator implements SendableEntityCreator
{

   private final String[] properties = new String[]
   {
      Lobby.PROPERTY_GAMES,
      Lobby.PROPERTY_ACCOUNT,
      Lobby.PROPERTY_NAME,
   };

   @Override
   public String[] getProperties()
   {
      return properties;
   }

   @Override
   public Object getSendableInstance(boolean prototyp)
   {
      return new Lobby();
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

      if (Lobby.PROPERTY_GAMES.equalsIgnoreCase(attrName))
      {
         return ((Lobby) entity).getGames();
      }

      if (Lobby.PROPERTY_ACCOUNT.equalsIgnoreCase(attrName))
      {
         return ((Lobby) entity).getAccount();
      }

      if (Lobby.PROPERTY_NAME.equalsIgnoreCase(attrName))
      {
         return ((Lobby) entity).getName();
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

      if (Lobby.PROPERTY_GAMES.equalsIgnoreCase(attribute))
      {
         ((Lobby) entity).withGames((Game) value);
         return true;
      }

      if (Lobby.PROPERTY_ACCOUNT.equalsIgnoreCase(attribute))
      {
         ((Lobby) entity).setAccount((Account) value);
         return true;
      }

      if (Lobby.PROPERTY_NAME.equalsIgnoreCase(attribute))
      {
         ((Lobby) entity).setName((String) value);
         return true;
      }

      return false;
   }

}