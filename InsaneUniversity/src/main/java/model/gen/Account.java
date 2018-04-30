package model.gen;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import model.gen.Account;
import model.gen.Game;
import model.gen.Lobby;
import model.gen.Message;
import model.gen.Player;


public class Account
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
   public static final String PROPERTY_PASSWORD = "password";

   private String password;

   public String getPassword()
   {
      return this.password;
   }

   public void setPassword(String value)
   {
      if (this.password != value)
      {         String oldValue = this.password;
         this.password = value;
         firePropertyChange(PROPERTY_PASSWORD, oldValue, value);
      }
   }

   public Account withPassword(String value)
   {
      setPassword(value);
      return this;
   }

   public static final String PROPERTY_USERNAME = "username";

   private String username;

   public String getUsername()
   {
      return this.username;
   }

   public void setUsername(String value)
   {
      if (this.username != value)
      {         String oldValue = this.username;
         this.username = value;
         firePropertyChange(PROPERTY_USERNAME, oldValue, value);
      }
   }

   public Account withUsername(String value)
   {
      setUsername(value);
      return this;
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

   public Account withLobby(Lobby value)
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

   public static final String PROPERTY_PLAYER = "player";

   private Player player = null;

   public Player getPlayer()
   {
      return this.player;
   }

   public boolean setPlayer(Player value)
   {
      boolean changed = false;
      if (this.player != value) {
         Player oldValue = this.player;
         this.player = value;
         firePropertyChange(PROPERTY_PLAYER, oldValue, value);
         changed = true;
      }
      return changed;
   }

   public Account withPlayer(Player value)
   {
      this.setPlayer(value);
      return this;
   }

   public Player createPlayer()
   {
      Player value = new Player();
      withPlayer(value);
      return value;
   }
}