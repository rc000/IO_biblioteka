package graphicalUserInterface;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import podsystemZarzadzaniaKsiazkami.Ksiazka;
import podsystemZarzadzaniaKsiazkami.Status;

public class Menu_Klient_Controller {

	@FXML
	private Button bWyswietl,bZarezerwowane,bWypozyczone,bZarezerwuj,bZapisz,bWyszukajKsiazka,bPokaz,bPokazR,bZapiszR;
	@FXML
	private Label lImie,lNazwisko,lUlica,lMiasto,lKod,lHaslo,lTytul,lPesel;
	@FXML 
	private TextField tfImie,tfNazwisko,tfUlica,tfMiasto,tfKod1,tfKod2,tfTytul,tfHaslo,tfPesel;
	@FXML
	private TableView <Ksiazka>tvKsiazki;
	 
	@FXML
	private TableView <Ksiazka>tvKsiazkiR;
	@FXML
	private TableColumn <Ksiazka,String> tcTytul;
	@FXML
	private TableColumn <Ksiazka,String> tcTytul1;
	@FXML
	private TableColumn <Ksiazka,String> tcAutor;
	@FXML
	private TableColumn <Ksiazka,String> tcAutor1;
	@FXML
	private TableColumn <Ksiazka,Status> tcStatus;
	@FXML
	private TableColumn <Ksiazka,Status> tcStatus1;
  	@FXML
	private TableColumn <Ksiazka,String> tcData_wyp;
	@FXML
	private TableColumn <Ksiazka,String> tcData_zwr;
	private Scene scena;
	private GUI gui;
	private ObservableList<Ksiazka>lista;
	 private List<Ksiazka> znalezione;
	public void wyszukaj()
	{
		
	}

	public ObservableList<Ksiazka> getProduct( List<Ksiazka> znalezione){
	lista=FXCollections.observableArrayList();
	
	if(znalezione!=null)
	{
	for(Ksiazka k:znalezione)
	{
		lista.add(k);
	}
	}
	return lista;
	}
	
	@FXML
	void initialize()
	{
		znalezione=new Vector<Ksiazka>();

		 wyswietl_dane(false);
		 wyswietl_haslo(false);
 		 wyswietl_tytul(false);
 		 bPokaz.setVisible(false);
 		 bZapiszR.setVisible(false);
 		 tvKsiazkiR.setVisible(false);
 		 
 		 bPokazR.setVisible(false);
			przypisz_handler();

 	}
	
	public void clear()
	{
		tfImie.clear();
		tfNazwisko.clear();
		tfPesel.clear();
		tfHaslo.clear();
 		tfKod1.clear();
		tfKod2.clear();
		tfTytul.clear();
		tfMiasto.clear();
		tfUlica.clear();
 		znalezione=null;
		getProduct(znalezione);
		tvKsiazki.setItems(getProduct(znalezione));

		
	}
	public void wyswietl_dane(boolean widocznosc)
	{
		lImie.setVisible(widocznosc);
		lNazwisko.setVisible(widocznosc);
		lUlica.setVisible(widocznosc);
		lMiasto.setVisible(widocznosc);
		lKod.setVisible(widocznosc);
 		lPesel.setVisible(widocznosc);
		
		tfImie.setVisible(widocznosc);
		tfNazwisko.setVisible(widocznosc);
		tfUlica.setVisible(widocznosc);
		tfMiasto.setVisible(widocznosc);
		tfKod1.setVisible(widocznosc);
		tfKod2.setVisible(widocznosc);
		tfPesel.setVisible(widocznosc);
		bZapisz.setVisible(widocznosc);
		//tvKsiazkiR.setVisible(false);
	}
	public void wyswietl_haslo(boolean widocznosc)
	{
		lHaslo.setVisible(widocznosc);
		tfHaslo.setVisible(widocznosc);

	}
	public void wyswietl_tytul(boolean widocznosc)
	{
			lTytul.setVisible(widocznosc);
			tfTytul.setVisible(widocznosc);
			bWyszukajKsiazka.setVisible(widocznosc);
			tvKsiazki.setVisible(widocznosc);
			//tvKsiazkiR.setVisible(false);

 	}
	public void wyswietl_tytul_rez(boolean widocznosc)
	{
			lTytul.setVisible(widocznosc);
			tfTytul.setVisible(widocznosc);
			bWyszukajKsiazka.setVisible(widocznosc);
			tvKsiazkiR.setVisible(widocznosc);
			//tvKsiazkiR.setVisible(false);

 	}
	@FXML
	public void ActionButton(ActionEvent e) throws FileNotFoundException, ClassNotFoundException, IOException
	{
		if(e.getSource()==bWyswietl)
		{
			clear();
			wyswietl_dane(true);
			wyswietl_haslo(true);
 			wyswietl_tytul(false);
			tvKsiazki.setVisible(false);
			tvKsiazkiR.setVisible(false);
			bZapiszR.setVisible(false);
			bPokaz.setVisible(false);
			bZapisz.setVisible(true);
			tfImie.setText(gui.get_imie_Klient());
			tfNazwisko.setText(gui.get_nazwisko_Klient());
			tfPesel.setText(gui.get_pesel_Klient());
			tfMiasto.setText(gui.get_miasto_Klient());
			tfUlica.setText(gui.get_ulica_Klient());
			tfKod1.setText(gui.get_kod_Klient().substring(0, 2));
			tfKod2.setText(gui.get_kod_Klient().substring(3, 5));
			tfHaslo.setText(gui.get_haslo_Klient());




		}
		if(e.getSource()==bWypozyczone)
		{
			clear();

			wyswietl_dane(false);
			wyswietl_haslo(false);
 			wyswietl_tytul(false);
			tvKsiazki.setVisible(true);
			bZapiszR.setVisible(false);
			bPokaz.setVisible(true);
			bPokazR.setVisible(false);


		}
		if(e.getSource()==bZarezerwowane)
		{
			clear();

			wyswietl_dane(false);
			wyswietl_haslo(false);
 			wyswietl_tytul(false);
			tvKsiazki.setVisible(true);
			bPokaz.setVisible(false);

			bPokazR.setVisible(true);


		}
		if(e.getSource()==bZarezerwuj)
		{
			clear();

			wyswietl_dane(false);
			wyswietl_haslo(false);
 			wyswietl_tytul(false);
 			wyswietl_tytul_rez(true);
			tvKsiazkiR.setVisible(true);
			bPokaz.setVisible(false);
			bPokazR.setVisible(false);
			bZapiszR.setVisible(true);



		}
		if(e.getSource()==bZapiszR)
		{
			Ksiazka rezerwacja= tvKsiazkiR.getSelectionModel().getSelectedItem();
			if(rezerwacja.getStatus().equals(Status.DOSTEPNA))
			{
				rezerwacja.setStatus(Status.REZERWACJA);
				
 			}
		}
		
	
	}
	public void set_Scena(Scene s)
	{
		this.scena=s;
	}
	public void set_GUI(GUI gui)
	{
		this.gui=gui;
	}
	
	public void przypisz_handler()
	{
 
		EventHandler<ActionEvent> handler=new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent e) {
				if(e.getSource()==bPokaz)
				{
 					String tytul=tfTytul.getText();
					znalezione=gui.wypozyczone();
					for (Ksiazka k:znalezione)
					{
						System.out.println(k.getTytul());
						System.out.println(k.getAutor());

					}
					znalezione=gui.wypozyczone();
					tcTytul.setCellValueFactory(new PropertyValueFactory<Ksiazka,String>("tytul"));
					tcAutor.setCellValueFactory(new PropertyValueFactory<Ksiazka,String>("autor"));
					tcStatus.setCellValueFactory(new PropertyValueFactory<Ksiazka,Status>("status"));
 					tcData_wyp.setCellValueFactory(new PropertyValueFactory<Ksiazka,String>("data_wyp"));
					tcData_zwr.setCellValueFactory(new PropertyValueFactory<Ksiazka,String>("data_zwr"));

					tcData_wyp.setText("Data wyp");
					tcData_zwr.setText("Data konca wyp");
					tvKsiazki.setItems(getProduct(znalezione));
					
				}
				if(e.getSource()==bWyszukajKsiazka)
				{
					String tytul=tfTytul.getText();
					System.out.println(tytul);
					znalezione=gui.znajdz(tytul);
					tcTytul1.setCellValueFactory(new PropertyValueFactory<Ksiazka,String>("tytul"));
					tcAutor1.setCellValueFactory(new PropertyValueFactory<Ksiazka,String>("autor"));
					tcStatus1.setCellValueFactory(new PropertyValueFactory<Ksiazka,Status>("status"));
				 


					tvKsiazkiR.setItems(getProduct(znalezione));
					
				}
				
				if(e.getSource()==bPokazR)
				{
 					String tytul=tfTytul.getText();
					znalezione=gui.zarezerwowane();
				 System.out.println("brak");
 					tcTytul.setCellValueFactory(new PropertyValueFactory<Ksiazka,String>("tytul"));
					tcAutor.setCellValueFactory(new PropertyValueFactory<Ksiazka,String>("autor"));
					tcStatus.setCellValueFactory(new PropertyValueFactory<Ksiazka,Status>("status"));
					tcData_wyp.setText("Data rez");
					tcData_zwr.setText("Data konca rez");

 					tcData_wyp.setCellValueFactory(new PropertyValueFactory<Ksiazka,String>("data_wyp"));
					tcData_zwr.setCellValueFactory(new PropertyValueFactory<Ksiazka,String>("data_zwr"));


					tvKsiazki.setItems(getProduct(znalezione));
					
				}
			}
		};
		bPokaz.addEventHandler(ActionEvent.ACTION, handler);
		bPokazR.addEventHandler(ActionEvent.ACTION, handler);
		bWyszukajKsiazka.addEventHandler(ActionEvent.ACTION, handler);


	}
}
