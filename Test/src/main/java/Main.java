 
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import testjavafxml.Administrator;
import testjavafxml.Pracownicy;
import testjavafxml.Pracownik;
import testjavafxml.Testcontroller;

public class Main extends Application{

	public static void main (String []args)
	{
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		Pracownicy pracownicy=new Pracownicy();
	 
		
		//pracownicy.wczytaj();
			// TODO Auto-generated method stub
	  FXMLLoader loader=new FXMLLoader();
	 loader.setLocation(this.getClass().getResource("logowanie.fxml"));
	 
	 
	 StackPane stack=loader.load();
	 Testcontroller Controller = loader.getController();
	  

	 Controller.set_pracownicy(pracownicy);
	 Scene scena=new Scene(stack);
	 primaryStage.setScene(scena);
		primaryStage.setTitle("Logowanie");
 		primaryStage.show();
  
   
 
 	 
  		
	}

}
