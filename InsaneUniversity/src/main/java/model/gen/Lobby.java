package model.gen;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import model.gen.Account;
import model.gen.Game;
import model.gen.Lobby;
import model.gen.Message;
import model.gen.Player;
import model.gen.util.GameSet;
import model.gen.util.PlayerSet;


public class Lobby
{
   protected PropertyChangeSupport listeners = null;

   public boolean firePropertyChange(String propertyName, Object oldValue, Object newValue) {
      if (listeners != null) {
         listeners.firePropertyChange(propertyName, oldValue, newValue);
         return true;
      }
      return false;
   }

   public boolean addPropertyChangeListener(PropertyChangeListener listener)
   {
      if (listeners == null) {
         listeners = new PropertyChangeSupport(this);
      }
      listeners.addPropertyChangeListener(listener);
      return true;
   }

   public boolean addPropertyChangeListener(String propertyName, PropertyChangeListener listener)
   {
      if (listeners == null) {
         listeners = new PropertyChangeSupport(this);
      }
      listeners.addPropertyChangeListener(propertyName, listener);
      return true;
   }

   public boolean removePropertyChangeListener(PropertyChangeListener listener)
   {
      if (listeners == null) {
         listeners.removePropertyChangeListener(listener);
      }
      listeners.removePropertyChangeListener(listener);
      return true;
   }

   public boolean removePropertyChangeListener(String propertyName,PropertyChangeListener listener)
   {
      if (listeners != null) {
         listeners.removePropertyChangeListener(propertyName, listener);
      }
      return true;
   }
   public static final String PROPERTY_NAME = "name";

   private String name;

   public String getName()
   {
      return this.name;
   }

   public void setName(String value)
   {
      if (this.name != value)
      {         String oldValue = this.name;
         this.name = value;
         firePropertyChange(PROPERTY_NAME, oldValue, value);
      }
   }

   public Lobby withName(String value)
   {
      setName(value);
      return this;
   }


   public static final String PROPERTY_GAMES = "games";

   private GameSet games = null;

   public GameSet getGames()
   {
      return this.games;
   }

   public Lobby withGames(Game... value)
   {
      if (value == null) {
         return this;
      }
      for (Game item : value) {
         if (item != null) {
            if (this.games == null) {
               this.games = new GameSet();
            }
            boolean changed = this.games.add(item);
            if (changed)
            {
               firePropertyChange(PROPERTY_GAMES, null, item);
            }
         }
      }
      return this;
   }

   public Lobby withoutGames(Game... value)
   {
      for (Game item : value) {
         if (this.games != null && item != null) {
            this.games.remove(item);
         }
      }
      return this;
   }

   public Game createGames()
   {
      Game value = new Game();
      withGames(value);
      return value;
   }

   public static final String PROPERTY_ACCOUNT = "account";

   private Account account = null;

   public Account getAccount()
   {
      return this.account;
   }

   public boolean setAccount(Account value)
   {
      boolean changed = false;
      if (this.account != value) {
         Account oldValue = this.account;
         this.account = value;
         firePropertyChange(PROPERTY_ACCOUNT, oldValue, value);
         changed = true;
      }
      return changed;
   }

   public Lobby withAccount(Account value)
   {
      this.setAccount(value);
      return this;
   }

   public Account createAccount()
   {
      Account value = new Account();
      withAccount(value);
      return value;
   }

   public static final String PROPERTY_PLAYERS = "players";

   private PlayerSet players = null;

   public PlayerSet getPlayers()
   {
      return this.players;
   }

   public Lobby withPlayers(Player... value)
   {
      if (value == null) {
         return this;
      }
      for (Player item : value) {
         if (item != null) {
            if (this.players == null) {
               this.players = new PlayerSet();
            }
            boolean changed = this.players.add(item);
            if (changed)
            {
               firePropertyChange(PROPERTY_PLAYERS, null, item);
            }
         }
      }
      return this;
   }

   public Lobby withoutPlayers(Player... value)
   {
      for (Player item : value) {
         if (this.players != null && item != null) {
            this.players.remove(item);
         }
      }
      return this;
   }

   public Player createPlayers()
   {
      Player value = new Player();
      withPlayers(value);
      return value;
   }
}