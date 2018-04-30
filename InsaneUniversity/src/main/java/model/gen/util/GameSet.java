package model.gen.util;
import model.gen.Game;
import de.uniks.networkparser.list.SimpleSet;
import java.util.Collection;
import de.uniks.networkparser.list.NumberList;
import de.uniks.networkparser.list.StringList;
import de.uniks.networkparser.list.ObjectSet;
import java.util.Collections;
import model.gen.Player;
import model.gen.Lobby;

public class GameSet extends SimpleSet<Game>
{

   public Class<?> getTypClass()
   {
      return Game.class;
   }

   public GameSet()
   {
      // empty
   }

   public GameSet(Game... objects)
   {
      for (Game obj : objects)
      {
         this.add(obj);
      }
   }

   public GameSet(Collection<Game> objects)
   {
      this.addAll(objects);
   }
		public static final GameSet EMPTY_SET = new GameSet().withFlag(GameSet.READONLY);

   public String getEntryType()
   {
      return "model.gen.Game";
   }
   @Override   public GameSet getNewList(boolean keyValue)
   {
      return new GameSet();
   }

   @SuppressWarnings("unchecked")
   public GameSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<Game>)value);
      }
      else if (value != null)
      {
         this.add((Game) value);
      }
      return this;
   }

   public NumberList getMaxPlayers()
   {
      NumberList result = new NumberList();
      for (Game obj : this)
      {
         result.add(obj.getMaxPlayers());
      }
      return result;
   }

   public GameSet filterMaxPlayers(int value)
   {
      GameSet result = new GameSet();
      for(Game obj : this)
      {
         if (value == obj.getMaxPlayers())
         {
            result.add(obj);
         }
      }
      return result;
   }

   public GameSet withMaxPlayers(int value) {
      for (Game obj : this)
      {
         obj.setMaxPlayers(value);
      }
      return this;
   }
   public StringList getName()
   {
      StringList result = new StringList();
      for (Game obj : this)
      {
         result.add(obj.getName());
      }
      return result;
   }

   public GameSet filterName(String value)
   {
      GameSet result = new GameSet();
      for(Game obj : this)
      {
         if (value == obj.getName())
         {
            result.add(obj);
         }
      }
      return result;
   }

   public GameSet withName(String value) {
      for (Game obj : this)
      {
         obj.setName(value);
      }
      return this;
   }
   public GameSet getPlayers()
   {
      GameSet result = new GameSet();
      for (Game obj : this)
      {
         result.with(obj.getPlayers());
      }
      return result;
   }

   public GameSet filterPlayers(Object value)
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
      GameSet answer = new GameSet();
      for (Game obj : this)
      {
         if (! Collections.disjoint(neighbors, obj.getPlayers()))
         {
            answer.add(obj);
         }
      }
      return answer;
   }

   public GameSet withPlayers(Player value)
   {
      for (Game obj : this)
      {
         obj.withPlayers(value);
      }
      return this;
   }
   public GameSet getLobby()
   {
      GameSet result = new GameSet();
      for (Game obj : this)
      {
         result.with(obj.getLobby());
      }
      return result;
   }

   public GameSet filterLobby(Object value)
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
      GameSet answer = new GameSet();
      for (Game obj : this)
      {
         if (neighbors.contains(obj.getLobby()) || (neighbors.isEmpty() && obj.getLobby() == null))
         {
            answer.add(obj);
         }
      }
      return answer;
   }

   public GameSet withLobby(Lobby value)
   {
      for (Game obj : this)
      {
         obj.withLobby(value);
      }
      return this;
   }
}