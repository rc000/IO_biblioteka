package testjavafxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Menu_Admin_Controller {

	@FXML
	private Button bDodajP,bDodajU,bWyloguj,bDodajK;
	private Pracownicy pracownicy;
	private Klienci klienci;
	private GUI gui;
	private Scene scena;
	
	public void set_Scena(Scene s)
	{
		this.scena=s;
	}
	public Menu_Admin_Controller()
	{
		
 	}
	@FXML
	void initialize()
	{
		klienci=new Klienci();
 
	}
	   public void set_pracownicy(Pracownicy p)
	    {
	    	this.pracownicy=p;
	    }
	   public void set_klienci(Klienci k)
	    {
	    	this.klienci=k;
	    }
	   public void set_GUI(GUI gui)
	   {
		   this.gui=gui;
	   }
	@FXML
	public void ActionButton(ActionEvent e)throws Exception
	{
		if(e.getSource()==bDodajP)
		{
			 FXMLLoader loader2=new FXMLLoader();
				 loader2.setLocation(this.getClass().getResource("/Dodaj_pracownik.fxml"));
				 
				 StackPane stack2=loader2.load();
				 
				 Scene scena2=new Scene(stack2);
				 Dodaj_pracownika_Controller Controller = loader2.getController();
				 Controller.set_GUI(gui);
				 Stage stage1 =new Stage();

				 stage1.setScene(scena2);
					stage1.setTitle("Dodawanie pracownika");
			 		stage1.show();
 
		}
		if(e.getSource()==bDodajU)
		{
		
			 FXMLLoader loader2=new FXMLLoader();
			 loader2.setLocation(this.getClass().getResource("/Dodaj_uzytkownik.fxml"));
			 
			 StackPane stack2=loader2.load();
			 
			 Scene scena2=new Scene(stack2);
			 Dodaj_uzytkownika_Controller Controller = loader2.getController();
			 Controller.set_GUI(gui);
			 Stage stage1 =new Stage();

			 stage1.setScene(scena2);
				stage1.setTitle("Dodawanie uzytkownika");
		 		stage1.show();
		}
		if(e.getSource()==bDodajK)
		{
			 FXMLLoader loader2=new FXMLLoader();
			 loader2.setLocation(this.getClass().getResource("/Dodaj_ksiazke.fxml"));
			 
			 StackPane stack2=loader2.load();
			 
			 Scene scena2=new Scene(stack2);
			 Dodaj_ksiazke_Controller Controller = loader2.getController();
			 Controller.set_GUI(gui);
			 Stage stage1 =new Stage();

			 stage1.setScene(scena2);
				stage1.setTitle("Dodawanie ksi¹¿ki");
		 		stage1.show();
		}
		if(e.getSource()==bWyloguj)
		{
 			Stage stage=new Stage();
			stage.setScene(scena);
			stage.setTitle("Logowanie");
	            ((Node) e.getSource()).getScene().getWindow().hide();

			stage.show();
			
		}
	}
	
}
