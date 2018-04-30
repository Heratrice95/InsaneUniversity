package model.gen.util;
import model.gen.Player;
import de.uniks.networkparser.list.SimpleSet;
import java.util.Collection;
import de.uniks.networkparser.list.StringList;
import de.uniks.networkparser.list.ObjectSet;
import model.gen.Account;
import java.util.Collections;
import model.gen.Message;
import model.gen.Game;

public class PlayerSet extends SimpleSet<Player>
{

   public Class<?> getTypClass()
   {
      return Player.class;
   }

   public PlayerSet()
   {
      // empty
   }

   public PlayerSet(Player... objects)
   {
      for (Player obj : objects)
      {
         this.add(obj);
      }
   }

   public PlayerSet(Collection<Player> objects)
   {
      this.addAll(objects);
   }
		public static final PlayerSet EMPTY_SET = new PlayerSet().withFlag(PlayerSet.READONLY);

   public String getEntryType()
   {
      return "model.gen.Player";
   }
   @Override   public PlayerSet getNewList(boolean keyValue)
   {
      return new PlayerSet();
   }

   @SuppressWarnings("unchecked")
   public PlayerSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<Player>)value);
      }
      else if (value != null)
      {
         this.add((Player) value);
      }
      return this;
   }

   public StringList getColor()
   {
      StringList result = new StringList();
      for (Player obj : this)
      {
         result.add(obj.getColor());
      }
      return result;
   }

   public PlayerSet filterColor(String value)
   {
      PlayerSet result = new PlayerSet();
      for(Player obj : this)
      {
         if (value == obj.getColor())
         {
            result.add(obj);
         }
      }
      return result;
   }

   public PlayerSet withColor(String value) {
      for (Player obj : this)
      {
         obj.setColor(value);
      }
      return this;
   }
   public StringList getName()
   {
      StringList result = new StringList();
      for (Player obj : this)
      {
         result.add(obj.getName());
      }
      return result;
   }

   public PlayerSet filterName(String value)
   {
      PlayerSet result = new PlayerSet();
      for(Player obj : this)
      {
         if (value == obj.getName())
         {
            result.add(obj);
         }
      }
      return result;
   }

   public PlayerSet withName(String value) {
      for (Player obj : this)
      {
         obj.setName(value);
      }
      return this;
   }
   public PlayerSet getAccount()
   {
      PlayerSet result = new PlayerSet();
      for (Player obj : this)
      {
         result.with(obj.getAccount());
      }
      return result;
   }

   public PlayerSet filterAccount(Object value)
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
      PlayerSet answer = new PlayerSet();
      for (Player obj : this)
      {
         if (neighbors.contains(obj.getAccount()) || (neighbors.isEmpty() && obj.getAccount() == null))
         {
            answer.add(obj);
         }
      }
      return answer;
   }

   public PlayerSet withAccount(Account value)
   {
      for (Player obj : this)
      {
         obj.withAccount(value);
      }
      return this;
   }
   public PlayerSet getMessages()
   {
      PlayerSet result = new PlayerSet();
      for (Player obj : this)
      {
         result.with(obj.getMessages());
      }
      return result;
   }

   public PlayerSet filterMessages(Object value)
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
      PlayerSet answer = new PlayerSet();
      for (Player obj : this)
      {
         if (! Collections.disjoint(neighbors, obj.getMessages()))
         {
            answer.add(obj);
         }
      }
      return answer;
   }

   public PlayerSet withMessages(Message value)
   {
      for (Player obj : this)
      {
         obj.withMessages(value);
      }
      return this;
   }
   public PlayerSet getGame()
   {
      PlayerSet result = new PlayerSet();
      for (Player obj : this)
      {
         result.with(obj.getGame());
      }
      return result;
   }

   public PlayerSet filterGame(Object value)
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
      PlayerSet answer = new PlayerSet();
      for (Player obj : this)
      {
         if (neighbors.contains(obj.getGame()) || (neighbors.isEmpty() && obj.getGame() == null))
         {
            answer.add(obj);
         }
      }
      return answer;
   }

   public PlayerSet withGame(Game value)
   {
      for (Player obj : this)
      {
         obj.withGame(value);
      }
      return this;
   }
}