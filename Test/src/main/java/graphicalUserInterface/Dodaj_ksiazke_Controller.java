package graphicalUserInterface;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Dodaj_ksiazke_Controller  {

	 @FXML
	private Button bZapisz;
	 @FXML
	 private TextField tfTytul,tfAutor,tfISBN,tfRok;
	private GUI gui;
		@FXML
		public void initialize()
		{
 		}
		   public void set_GUI(GUI gui)
		    {
		    	this.gui=gui;
		    }
	@FXML
	public void ActionButton(ActionEvent e) throws FileNotFoundException, ClassNotFoundException, IOException
		{
				if(e.getSource()==bZapisz)
				{	
					String tytul=tfTytul.getText();
					String autor=tfAutor.getText();
					String ISBN=tfISBN.getText();
					int rok=Integer.parseInt(tfRok.getText());		
					gui.dodaj_ksiazke(tytul, autor, ISBN, 1995);
					bZapisz.setText("Dodano pomyslnie");
				}
		}
	 	
}
