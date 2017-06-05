package testjavafxml;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Testcontroller  {

	@FXML
	private Button button1;
	@FXML
	private RadioButton rLibrarian,rUser,rAdmin;
	@FXML
	private TextField tfLogin;
	@FXML
	private PasswordField pfPassword;
	@FXML
	private Label lLogin,lPassword,lStatus;
    private ToggleGroup group;
    private Pracownicy pracownicy;
    private Klienci klienci;
    private GUI gui;
	private boolean log_in;

    public void set_pracownicy(Pracownicy p)
    {
    	this.pracownicy=p;
    }
	public Testcontroller()
	{
 	}
	
	@FXML
	void initialize()
	{
		group= new ToggleGroup();
 		button1.setText("Zaloguj");
		rLibrarian.setText("Pracownik");
		rUser.setText("U¿ytkownik");
		rAdmin.setText("Administrator");
		lLogin.setText("Login");
		lPassword.setText("Has³o");
	    rLibrarian.setToggleGroup(group);
	    rLibrarian.setSelected(true);
	    rUser.setToggleGroup(group);
	    rAdmin.setToggleGroup(group);
	    lStatus.setVisible(false);
 	    gui=gui.getInstance();
	    gui.wczytaj();


	}
	@FXML
	public void ActionRadio(EventType<MouseEvent> MOUSE_CLICKED)
	{
	 
	}
	
	@FXML
	public void ActionButton(ActionEvent e) throws Exception
	{
		if(e.getSource() ==button1)
		{
 
			String login=tfLogin.getText();
			String password=pfPassword.getText();
 

			if(rAdmin.isSelected())
			{
 
					log_in=gui.zaloguj_admin(login, password);
					if (log_in==true)
					{
						
						 FXMLLoader loader1=new FXMLLoader();
						 loader1.setLocation(this.getClass().getResource("/menu_admin.fxml"));
						 
						 StackPane stack1=loader1.load();
						 Menu_Admin_Controller Controller = loader1.getController();
						 Controller.set_Scena( ((Node) e.getSource()).getScene());
						 Controller.set_GUI(gui);
						 Scene scena1=new Scene(stack1);
						 Stage stage =new Stage();

						 stage.setScene(scena1);
							stage.setTitle("Menu Admin");
					 		stage.show();
						
 				            ((Node) e.getSource()).getScene().getWindow().hide();
 				           

 						 
 						  
 						 
 						
					}
					else 
					{
					    lStatus.setText("Bledny login lub haslo");

 						lStatus.setVisible(true);
					}

			
			}
			
			if(rLibrarian.isSelected())
			{
  
				log_in=gui.zaloguj_pracownik(login, password);
				if (log_in==true)
				{
	 						 
	 	 					 FXMLLoader loader1=new FXMLLoader();
	 						 loader1.setLocation(this.getClass().getResource("/Menu_pracownik.fxml"));
	 						 
	 						 BorderPane stack1=loader1.load();
	 						 Menu_Pracownik_Controller Controller = loader1.getController();
	 						 Controller.set_GUI(gui);
 	 						 Controller.set_Scena( ((Node) e.getSource()).getScene());
	 						 Scene scena1=new Scene(stack1);
	 						 Stage stage =new Stage();

	 						 stage.setScene(scena1);
	 							stage.setTitle("Menu Pracownik");
	 					 		stage.show();
	 				            ((Node) e.getSource()).getScene().getWindow().hide();

						}
						else
						{
						    lStatus.setText("Bledny login lub haslo");

		 					lStatus.setVisible(true);
						}
						 
					
				
			}
			if(rUser.isSelected())
			{
				log_in=gui.zaloguj_uzytkownik(login, password);
				if (log_in==true)
				{
				  
	 						 
	 	 					 FXMLLoader loader2=new FXMLLoader();
	 						 loader2.setLocation(this.getClass().getResource("/Menu_klient.fxml"));
	 						 
	 						 StackPane stack2=loader2.load();
	 						 Menu_Klient_Controller Controller1 = loader2.getController();
	 						 Controller1.set_GUI(gui);
 	 						 Controller1.set_Scena( ((Node) e.getSource()).getScene());
	 						 Scene scena2=new Scene(stack2);
	 						 Stage stage1 =new Stage();

	 						 stage1.setScene(scena2);
	 							stage1.setTitle("Menu Uzytkownik");
	 					 		stage1.show();
	 				            
	 					 		//((Node) e.getSource()).getScene().getWindow().hide();

						}
						else
						{
						    lStatus.setText("Bledny login lub haslo");

		 					lStatus.setVisible(true);
						}
						 
					
			}
 		}
		 
	}
 

 
}
