package model.gen.util;
import model.gen.Message;
import de.uniks.networkparser.list.SimpleSet;
import java.util.Collection;
import de.uniks.networkparser.list.StringList;
import de.uniks.networkparser.list.ObjectSet;
import model.gen.Player;

public class MessageSet extends SimpleSet<Message>
{

   public Class<?> getTypClass()
   {
      return Message.class;
   }

   public MessageSet()
   {
      // empty
   }

   public MessageSet(Message... objects)
   {
      for (Message obj : objects)
      {
         this.add(obj);
      }
   }

   public MessageSet(Collection<Message> objects)
   {
      this.addAll(objects);
   }
		public static final MessageSet EMPTY_SET = new MessageSet().withFlag(MessageSet.READONLY);

   public String getEntryType()
   {
      return "model.gen.Message";
   }
   @Override   public MessageSet getNewList(boolean keyValue)
   {
      return new MessageSet();
   }

   @SuppressWarnings("unchecked")
   public MessageSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<Message>)value);
      }
      else if (value != null)
      {
         this.add((Message) value);
      }
      return this;
   }

   public StringList getMessage()
   {
      StringList result = new StringList();
      for (Message obj : this)
      {
         result.add(obj.getMessage());
      }
      return result;
   }

   public MessageSet filterMessage(String value)
   {
      MessageSet result = new MessageSet();
      for(Message obj : this)
      {
         if (value == obj.getMessage())
         {
            result.add(obj);
         }
      }
      return result;
   }

   public MessageSet withMessage(String value) {
      for (Message obj : this)
      {
         obj.setMessage(value);
      }
      return this;
   }
   public MessageSet getPlayer()
   {
      MessageSet result = new MessageSet();
      for (Message obj : this)
      {
         result.with(obj.getPlayer());
      }
      return result;
   }

   public MessageSet filterPlayer(Object value)
   {
      ObjectSet neighbors = new ObjectSet();
      if (value instanceof Collection)
      {
         neighbors.addAll((Collection<?>) value);
      }
      else
      {
         neighbors.add(value);
      }
      MessageSet answer = new MessageSet();
      for (Message obj : this)
      {
         if (neighbors.contains(obj.getPlayer()) || (neighbors.isEmpty() && obj.getPlayer() == null))
         {
            answer.add(obj);
         }
      }
      return answer;
   }

   public MessageSet withPlayer(Player value)
   {
      for (Message obj : this)
      {
         obj.withPlayer(value);
      }
      return this;
   }
}