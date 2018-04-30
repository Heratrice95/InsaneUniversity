package model.gen;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import model.gen.Account;
import model.gen.Game;
import model.gen.Lobby;
import model.gen.Message;
import model.gen.Player;


public class Message
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
   public static final String PROPERTY_MESSAGE = "message";

   private String message;

   public String getMessage()
   {
      return this.message;
   }

   public void setMessage(String value)
   {
      if (this.message != value)
      {         String oldValue = this.message;
         this.message = value;
         firePropertyChange(PROPERTY_MESSAGE, oldValue, value);
      }
   }

   public Message withMessage(String value)
   {
      setMessage(value);
      return this;
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

   public Message withPlayer(Player value)
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