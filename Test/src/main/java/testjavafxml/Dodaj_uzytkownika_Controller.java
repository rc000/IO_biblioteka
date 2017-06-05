package testjavafxml;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Dodaj_uzytkownika_Controller extends Dodaj_pracownika_Controller{

 	@FXML
	public void initialize()
	{
 		super.initialize();
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

 		gui.dodaj_uzytkownika(imie, nazwisko, pesel, miasto, ulica, kod);
 	    
 	    bZatwierdz.setText("Dodano pomyslnie");
	}
	}
}
