package testjavafxml;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Dodaj_pracownika_Controller {

	@FXML
	protected TextField tfImie,tfNazwisko,tfPesel,tfMiasto,tfUlica,tfKod1,tfKod2;
	@FXML
	protected Button bZatwierdz;
	protected GUI gui;
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
		if(e.getSource()==bZatwierdz)
		{
		String imie=tfImie.getText();
		String nazwisko=tfNazwisko.getText();
		String pesel=tfPesel.getText();
		String miasto=tfMiasto.getText();
		String ulica=tfUlica.getText();
		String kod=tfKod1.getText()+"-"+tfKod2.getText();

		
		gui.dodaj_pracownika(imie, nazwisko,pesel, miasto, ulica, kod);
	 
	    bZatwierdz.setText("Dodano pomyslnie");
   			 
	}
	}
}
