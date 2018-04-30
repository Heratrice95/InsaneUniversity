package model.gen.util;
import de.uniks.networkparser.interfaces.SendableEntityCreator;
import model.gen.Account;
import model.gen.Lobby;
import model.gen.Player;


public class AccountCreator implements SendableEntityCreator
{

   private final String[] properties = new String[]
   {
      Account.PROPERTY_LOBBY,
      Account.PROPERTY_PLAYER,
      Account.PROPERTY_PASSWORD,
      Account.PROPERTY_USERNAME,
   };

   @Override
   public String[] getProperties()
   {
      return properties;
   }

   @Override
   public Object getSendableInstance(boolean prototyp)
   {
      return new Account();
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

      if (Account.PROPERTY_LOBBY.equalsIgnoreCase(attrName))
      {
         return ((Account) entity).getLobby();
      }

      if (Account.PROPERTY_PLAYER.equalsIgnoreCase(attrName))
      {
         return ((Account) entity).getPlayer();
      }

      if (Account.PROPERTY_PASSWORD.equalsIgnoreCase(attrName))
      {
         return ((Account) entity).getPassword();
      }

      if (Account.PROPERTY_USERNAME.equalsIgnoreCase(attrName))
      {
         return ((Account) entity).getUsername();
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

      if (Account.PROPERTY_LOBBY.equalsIgnoreCase(attribute))
      {
         ((Account) entity).setLobby((Lobby) value);
         return true;
      }

      if (Account.PROPERTY_PLAYER.equalsIgnoreCase(attribute))
      {
         ((Account) entity).setPlayer((Player) value);
         return true;
      }

      if (Account.PROPERTY_PASSWORD.equalsIgnoreCase(attribute))
      {
         ((Account) entity).setPassword((String) value);
         return true;
      }

      if (Account.PROPERTY_USERNAME.equalsIgnoreCase(attribute))
      {
         ((Account) entity).setUsername((String) value);
         return true;
      }

      return false;
   }

}