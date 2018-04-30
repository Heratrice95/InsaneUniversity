package model.gen.util;
import de.uniks.networkparser.interfaces.SendableEntityCreator;
import model.gen.Player;
import model.gen.Account;
import model.gen.Message;
import model.gen.Game;


public class PlayerCreator implements SendableEntityCreator
{

   private final String[] properties = new String[]
   {
      Player.PROPERTY_COLOR,
      Player.PROPERTY_NAME,
      Player.PROPERTY_ACCOUNT,
      Player.PROPERTY_MESSAGES,
      Player.PROPERTY_GAME,
   };

   @Override
   public String[] getProperties()
   {
      return properties;
   }

   @Override
   public Object getSendableInstance(boolean prototyp)
   {
      return new Player();
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

      if (Player.PROPERTY_COLOR.equalsIgnoreCase(attrName))
      {
         return ((Player) entity).getColor();
      }

      if (Player.PROPERTY_NAME.equalsIgnoreCase(attrName))
      {
         return ((Player) entity).getName();
      }

      if (Player.PROPERTY_ACCOUNT.equalsIgnoreCase(attrName))
      {
         return ((Player) entity).getAccount();
      }

      if (Player.PROPERTY_MESSAGES.equalsIgnoreCase(attrName))
      {
         return ((Player) entity).getMessages();
      }

      if (Player.PROPERTY_GAME.equalsIgnoreCase(attrName))
      {
         return ((Player) entity).getGame();
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

      if (Player.PROPERTY_COLOR.equalsIgnoreCase(attribute))
      {
         ((Player) entity).setColor((String) value);
         return true;
      }

      if (Player.PROPERTY_NAME.equalsIgnoreCase(attribute))
      {
         ((Player) entity).setName((String) value);
         return true;
      }

      if (Player.PROPERTY_ACCOUNT.equalsIgnoreCase(attribute))
      {
         ((Player) entity).setAccount((Account) value);
         return true;
      }

      if (Player.PROPERTY_MESSAGES.equalsIgnoreCase(attribute))
      {
         ((Player) entity).withMessages((Message) value);
         return true;
      }

      if (Player.PROPERTY_GAME.equalsIgnoreCase(attribute))
      {
         ((Player) entity).setGame((Game) value);
         return true;
      }

      return false;
   }

}