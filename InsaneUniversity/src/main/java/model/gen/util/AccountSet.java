package model.gen.util;
import model.gen.Account;
import de.uniks.networkparser.list.SimpleSet;
import java.util.Collection;
import de.uniks.networkparser.list.StringList;
import de.uniks.networkparser.list.ObjectSet;
import model.gen.Lobby;
import model.gen.Player;

public class AccountSet extends SimpleSet<Account>
{

   public Class<?> getTypClass()
   {
      return Account.class;
   }

   public AccountSet()
   {
      // empty
   }

   public AccountSet(Account... objects)
   {
      for (Account obj : objects)
      {
         this.add(obj);
      }
   }

   public AccountSet(Collection<Account> objects)
   {
      this.addAll(objects);
   }
		public static final AccountSet EMPTY_SET = new AccountSet().withFlag(AccountSet.READONLY);

   public String getEntryType()
   {
      return "model.gen.Account";
   }
   @Override   public AccountSet getNewList(boolean keyValue)
   {
      return new AccountSet();
   }

   @SuppressWarnings("unchecked")
   public AccountSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<Account>)value);
      }
      else if (value != null)
      {
         this.add((Account) value);
      }
      return this;
   }

   public StringList getPassword()
   {
      StringList result = new StringList();
      for (Account obj : this)
      {
         result.add(obj.getPassword());
      }
      return result;
   }

   public AccountSet filterPassword(String value)
   {
      AccountSet result = new AccountSet();
      for(Account obj : this)
      {
         if (value == obj.getPassword())
         {
            result.add(obj);
         }
      }
      return result;
   }

   public AccountSet withPassword(String value) {
      for (Account obj : this)
      {
         obj.setPassword(value);
      }
      return this;
   }
   public StringList getUsername()
   {
      StringList result = new StringList();
      for (Account obj : this)
      {
         result.add(obj.getUsername());
      }
      return result;
   }

   public AccountSet filterUsername(String value)
   {
      AccountSet result = new AccountSet();
      for(Account obj : this)
      {
         if (value == obj.getUsername())
         {
            result.add(obj);
         }
      }
      return result;
   }

   public AccountSet withUsername(String value) {
      for (Account obj : this)
      {
         obj.setUsername(value);
      }
      return this;
   }
   public AccountSet getLobby()
   {
      AccountSet result = new AccountSet();
      for (Account obj : this)
      {
         result.with(obj.getLobby());
      }
      return result;
   }

   public AccountSet filterLobby(Object value)
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
      AccountSet answer = new AccountSet();
      for (Account obj : this)
      {
         if (neighbors.contains(obj.getLobby()) || (neighbors.isEmpty() && obj.getLobby() == null))
         {
            answer.add(obj);
         }
      }
      return answer;
   }

   public AccountSet withLobby(Lobby value)
   {
      for (Account obj : this)
      {
         obj.withLobby(value);
      }
      return this;
   }
   public AccountSet getPlayer()
   {
      AccountSet result = new AccountSet();
      for (Account obj : this)
      {
         result.with(obj.getPlayer());
      }
      return result;
   }

   public AccountSet filterPlayer(Object value)
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
      AccountSet answer = new AccountSet();
      for (Account obj : this)
      {
         if (neighbors.contains(obj.getPlayer()) || (neighbors.isEmpty() && obj.getPlayer() == null))
         {
            answer.add(obj);
         }
      }
      return answer;
   }

   public AccountSet withPlayer(Player value)
   {
      for (Account obj : this)
      {
         obj.withPlayer(value);
      }
      return this;
   }
}