package model.gen.util;
import de.uniks.networkparser.interfaces.SendableEntityCreator;
import model.gen.Message;
import model.gen.Player;


public class MessageCreator implements SendableEntityCreator
{

   private final String[] properties = new String[]
   {
      Message.PROPERTY_MESSAGE,
      Message.PROPERTY_PLAYER,
   };

   @Override
   public String[] getProperties()
   {
      return properties;
   }

   @Override
   public Object getSendableInstance(boolean prototyp)
   {
      return new Message();
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

      if (Message.PROPERTY_MESSAGE.equalsIgnoreCase(attrName))
      {
         return ((Message) entity).getMessage();
      }

      if (Message.PROPERTY_PLAYER.equalsIgnoreCase(attrName))
      {
         return ((Message) entity).getPlayer();
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

      if (Message.PROPERTY_MESSAGE.equalsIgnoreCase(attribute))
      {
         ((Message) entity).setMessage((String) value);
         return true;
      }

      if (Message.PROPERTY_PLAYER.equalsIgnoreCase(attribute))
      {
         ((Message) entity).setPlayer((Player) value);
         return true;
      }

      return false;
   }

}