
import controller.LoginScreenController;
import javafx.application.Application;
import javafx.stage.Stage;


public class MainApplication extends Application{
	
	
	   @Override
	   public void start(Stage primaryStage) throws Exception
	   { 
	      LoginScreenController loginScreenController =  new LoginScreenController();
	      
	      loginScreenController.show(primaryStage);
	      
	   }


	   public static void main(String[] args)
	   {
	      launch(args);
	   }

}
