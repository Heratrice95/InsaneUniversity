package model.gen.util;
import model.gen.Lobby;
import de.uniks.networkparser.list.SimpleSet;
import java.util.Collection;
import de.uniks.networkparser.list.StringList;
import de.uniks.networkparser.list.ObjectSet;
import java.util.Collections;
import model.gen.Game;
import model.gen.Account;
import model.gen.Player;

public class LobbySet extends SimpleSet<Lobby>
{

   public Class<?> getTypClass()
   {
      return Lobby.class;
   }

   public LobbySet()
   {
      // empty
   }

   public LobbySet(Lobby... objects)
   {
      for (Lobby obj : objects)
      {
         this.add(obj);
      }
   }

   public LobbySet(Collection<Lobby> objects)
   {
      this.addAll(objects);
   }
		public static final LobbySet EMPTY_SET = new LobbySet().withFlag(LobbySet.READONLY);

   public String getEntryType()
   {
      return "model.gen.Lobby";
   }
   @Override   public LobbySet getNewList(boolean keyValue)
   {
      return new LobbySet();
   }

   @SuppressWarnings("unchecked")
   public LobbySet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<Lobby>)value);
      }
      else if (value != null)
      {
         this.add((Lobby) value);
      }
      return this;
   }

   public StringList getName()
   {
      StringList result = new StringList();
      for (Lobby obj : this)
      {
         result.add(obj.getName());
      }
      return result;
   }

   public LobbySet filterName(String value)
   {
      LobbySet result = new LobbySet();
      for(Lobby obj : this)
      {
         if (value == obj.getName())
         {
            result.add(obj);
         }
      }
      return result;
   }

   public LobbySet withName(String value) {
      for (Lobby obj : this)
      {
         obj.setName(value);
      }
      return this;
   }
   public LobbySet getGames()
   {
      LobbySet result = new LobbySet();
      for (Lobby obj : this)
      {
         result.with(obj.getGames());
      }
      return result;
   }

   public LobbySet filterGames(Object value)
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
      LobbySet answer = new LobbySet();
      for (Lobby obj : this)
      {
         if (! Collections.disjoint(neighbors, obj.getGames()))
         {
            answer.add(obj);
         }
      }
      return answer;
   }

   public LobbySet withGames(Game value)
   {
      for (Lobby obj : this)
      {
         obj.withGames(value);
      }
      return this;
   }
   public LobbySet getAccount()
   {
      LobbySet result = new LobbySet();
      for (Lobby obj : this)
      {
         result.with(obj.getAccount());
      }
      return result;
   }

   public LobbySet filterAccount(Object value)
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
      LobbySet answer = new LobbySet();
      for (Lobby obj : this)
      {
         if (neighbors.contains(obj.getAccount()) || (neighbors.isEmpty() && obj.getAccount() == null))
         {
            answer.add(obj);
         }
      }
      return answer;
   }

   public LobbySet withAccount(Account value)
   {
      for (Lobby obj : this)
      {
         obj.withAccount(value);
      }
      return this;
   }
   public LobbySet getPlayers()
   {
      LobbySet result = new LobbySet();
      for (Lobby obj : this)
      {
         result.with(obj.getPlayers());
      }
      return result;
   }

   public LobbySet filterPlayers(Object value)
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
      LobbySet answer = new LobbySet();
      for (Lobby obj : this)
      {
         if (! Collections.disjoint(neighbors, obj.getPlayers()))
         {
            answer.add(obj);
         }
      }
      return answer;
   }

   public LobbySet withPlayers(Player value)
   {
      for (Lobby obj : this)
      {
         obj.withPlayers(value);
      }
      return this;
   }
}