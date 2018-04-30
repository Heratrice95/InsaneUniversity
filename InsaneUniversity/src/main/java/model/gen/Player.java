package model.gen;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import model.gen.Account;
import model.gen.Game;
import model.gen.Lobby;
import model.gen.Message;
import model.gen.Player;
import model.gen.util.MessageSet;


public class Player
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
   public static final String PROPERTY_COLOR = "color";

   private String color;

   public String getColor()
   {
      return this.color;
   }

   public void setColor(String value)
   {
      if (this.color != value)
      {         String oldValue = this.color;
         this.color = value;
         firePropertyChange(PROPERTY_COLOR, oldValue, value);
      }
   }

   public Player withColor(String value)
   {
      setColor(value);
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

   public Player withName(String value)
   {
      setName(value);
      return this;
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

   public Player withAccount(Account value)
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

   public static final String PROPERTY_MESSAGES = "messages";

   private MessageSet messages = null;

   public MessageSet getMessages()
   {
      return this.messages;
   }

   public Player withMessages(Message... value)
   {
      if (value == null) {
         return this;
      }
      for (Message item : value) {
         if (item != null) {
            if (this.messages == null) {
               this.messages = new MessageSet();
            }
            boolean changed = this.messages.add(item);
            if (changed)
            {
               firePropertyChange(PROPERTY_MESSAGES, null, item);
            }
         }
      }
      return this;
   }

   public Player withoutMessages(Message... value)
   {
      for (Message item : value) {
         if (this.messages != null && item != null) {
            this.messages.remove(item);
         }
      }
      return this;
   }

   public Message createMessages()
   {
      Message value = new Message();
      withMessages(value);
      return value;
   }

   public static final String PROPERTY_GAME = "game";

   private Game game = null;

   public Game getGame()
   {
      return this.game;
   }

   public boolean setGame(Game value)
   {
      boolean changed = false;
      if (this.game != value) {
         Game oldValue = this.game;
         this.game = value;
         firePropertyChange(PROPERTY_GAME, oldValue, value);
         changed = true;
      }
      return changed;
   }

   public Player withGame(Game value)
   {
      this.setGame(value);
      return this;
   }

   public Game createGame()
   {
      Game value = new Game();
      withGame(value);
      return value;
   }
}