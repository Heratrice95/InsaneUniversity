package model.gen;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import model.gen.Account;
import model.gen.Game;
import model.gen.Lobby;
import model.gen.Message;
import model.gen.Player;
import model.gen.util.PlayerSet;


public class Game
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
   public static final String PROPERTY_MAXPLAYERS = "maxPlayers";

   private int maxPlayers;

   public int getMaxPlayers()
   {
      return this.maxPlayers;
   }

   public void setMaxPlayers(int value)
   {
      if (this.maxPlayers != value)
      {         int oldValue = this.maxPlayers;
         this.maxPlayers = value;
         firePropertyChange(PROPERTY_MAXPLAYERS, oldValue, value);
      }
   }

   public Game withMaxPlayers(int value)
   {
      setMaxPlayers(value);
      return this;
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

   public Game withName(String value)
   {
      setName(value);
      return this;
   }


   public static final String PROPERTY_PLAYERS = "players";

   private PlayerSet players = null;

   public PlayerSet getPlayers()
   {
      return this.players;
   }

   public Game withPlayers(Player... value)
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

   public Game withoutPlayers(Player... value)
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

   public static final String PROPERTY_LOBBY = "lobby";

   private Lobby lobby = null;

   public Lobby getLobby()
   {
      return this.lobby;
   }

   public boolean setLobby(Lobby value)
   {
      boolean changed = false;
      if (this.lobby != value) {
         Lobby oldValue = this.lobby;
         this.lobby = value;
         firePropertyChange(PROPERTY_LOBBY, oldValue, value);
         changed = true;
      }
      return changed;
   }

   public Game withLobby(Lobby value)
   {
      this.setLobby(value);
      return this;
   }

   public Lobby createLobby()
   {
      Lobby value = new Lobby();
      withLobby(value);
      return value;
   }
}