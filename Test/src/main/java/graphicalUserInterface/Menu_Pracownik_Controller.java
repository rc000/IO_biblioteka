package graphicalUserInterface;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
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
import podsystemZarzadzaniaKontem.Pracownik;
import podsystemZarzadzaniaKsiazkami.Ksiazka;
import podsystemZarzadzaniaKsiazkami.Status;

public class Menu_Pracownik_Controller {

	private Pracownik pracownik;
	private String tytul;

	private Scene scena;
	@FXML
	private Button bEditSwoje,bEditClient,bWypozycz,bWyszukaj,bZapisz,bWyszukajLogin,bWyszukajKsiazka,bZatwierdz,bPrzyjmij,bZwrot,bWyszukajZwrot,bPokaz;
	@FXML
	private Label lImie,lNazwisko,lUlica,lMiasto,lKod,lHaslo,lKod1,lLimit,lTytul,lLoginKlienta,lPesel,lStatus;
	@FXML 
	private TextField tfImie,tfNazwisko,tfUlica,tfMiasto,tfKod1,tfKod2,tfLoginKlienta,tfTytul,tfHaslo,tfPesel;
	@FXML
	private TableView <Ksiazka>tvKsiazki;
	@FXML
	private TableColumn <Ksiazka,String> tcTytul;
	@FXML
	private TableColumn <Ksiazka,String> tcAutor;
	@FXML
	private TableColumn <Ksiazka,Status> tcStatus;
	@FXML
	private TableColumn <Ksiazka,String> tcLogin;
	@FXML
	private TableColumn <Ksiazka,String> tcData_wyp;
	@FXML
	private TableColumn <Ksiazka,String> tcData_zwr;
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
	
	void set_pracownik(Pracownik p)
	{
		this.pracownik=p;
	}
	public void set_Scena(Scene s)
	{
		this.scena=s;
	}
	public void set_GUI(GUI gui)
	{
		this.gui=gui;
	}
	@FXML
	void initialize()
	{
		znalezione=new Vector<Ksiazka>();

		 wyswietl_dane(false);
		 wyswietl_haslo(false);
		 wyswietl_login(false);
		 lLimit.setVisible(false);
		 wyswietl_tytul(false);
		 bZwrot.setVisible(false);
		 lStatus.setVisible(false);
		 bPokaz.setVisible(false);
		 bZatwierdz.setVisible(false);
		bWyszukajZwrot.setVisible(false);
	}
	public void clear()
	{
		tfImie.clear();
		tfNazwisko.clear();
		tfPesel.clear();
		tfHaslo.clear();
		tfLoginKlienta.clear();
		tfKod1.clear();
		tfKod2.clear();
		tfTytul.clear();
		tfMiasto.clear();
		tfUlica.clear();
		lLimit.setVisible(false);
		bZwrot.setVisible(false);
		bWyszukajZwrot.setVisible(false);
		bPokaz.setVisible(false);
		lStatus.setVisible(false);
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
		lKod1.setVisible(widocznosc);
		lPesel.setVisible(widocznosc);
		
		tfImie.setVisible(widocznosc);
		tfNazwisko.setVisible(widocznosc);
		tfUlica.setVisible(widocznosc);
		tfMiasto.setVisible(widocznosc);
		tfKod1.setVisible(widocznosc);
		tfKod2.setVisible(widocznosc);
		tfPesel.setVisible(widocznosc);
		bZapisz.setVisible(widocznosc);
	}
	public void wyswietl_haslo(boolean widocznosc)
	{
		lHaslo.setVisible(widocznosc);
		tfHaslo.setVisible(widocznosc);

	}
	public void wyswietl_login(boolean widocznosc)
	{
			lLoginKlienta.setVisible(widocznosc);
			tfLoginKlienta.setVisible(widocznosc);
			bWyszukajLogin.setVisible(widocznosc);
	}
	public void wyswietl_tytul(boolean widocznosc)
	{
			lTytul.setVisible(widocznosc);
			tfTytul.setVisible(widocznosc);
			bWyszukajKsiazka.setVisible(widocznosc);
			tvKsiazki.setVisible(widocznosc);
	}
	@FXML
	public void ActionButton(ActionEvent e) throws FileNotFoundException, ClassNotFoundException, IOException
	{
		if(e.getSource()==bEditSwoje)
		{
			clear();
			wyswietl_dane(true);
			wyswietl_haslo(true);
			wyswietl_login(false);
			wyswietl_tytul(false);
			tvKsiazki.setVisible(false);
			bZapisz.setVisible(true);
			tfImie.setText(gui.get_imie_Pracownik());
			tfNazwisko.setText(gui.get_nazwisko_Pracownik());
			tfPesel.setText(gui.get_pesel_Pracownik());
			tfMiasto.setText(gui.get_miasto_Pracownik());
			tfUlica.setText(gui.get_ulica_Pracownik());
			tfKod1.setText(gui.get_kod_Pracownik().substring(0, 2));
			tfKod2.setText(gui.get_kod_Pracownik().substring(3, 5));
			tfHaslo.setText(gui.get_haslo_Pracownik());




		}
		if(e.getSource()==bWyszukaj)
		{
			clear();
 			wyswietl_dane(false);
			wyswietl_haslo(false);
			wyswietl_login(false);

			wyswietl_tytul(true);
			bZatwierdz.setVisible(false);
			tvKsiazki.setVisible(true);
			przypisz_handler();



		}
		if(e.getSource()==bEditClient)
		{
			clear();

 			wyswietl_dane(true);
			wyswietl_haslo(false);
			wyswietl_login(true);
			wyswietl_tytul(false);
			tvKsiazki.setVisible(false);
			bZapisz.setVisible(true);
	 			
			

		}
		if(e.getSource()==bWypozycz)
		{
			clear();

			wyswietl_dane(false);
			wyswietl_haslo(false);
			wyswietl_login(true);
			wyswietl_tytul(true);
	 
 			tvKsiazki.setVisible(true);
			bZapisz.setVisible(true);
			bZatwierdz.setVisible(true);

			 
		
		}
		if(e.getSource()==bPrzyjmij)
		{
			clear();

			wyswietl_dane(false);
			wyswietl_haslo(false);
			wyswietl_login(true);
			wyswietl_tytul(true);
			bZwrot.setVisible(true);
			lTytul.setVisible(false);
			bWyszukajLogin.setVisible(false);
			tfTytul.setVisible(false);
			bWyszukajKsiazka.setVisible(false);
			bZatwierdz.setVisible(false);
			bWyszukajZwrot.setVisible(true);
			bPokaz.setVisible(true);

 			tvKsiazki.setVisible(true);
			bZapisz.setVisible(true);
			przypisz_handler();

			 
		
		}
		if(e.getSource()==bWyszukajLogin  )
		{
			
			String login=tfLoginKlienta.getText();
			lStatus.setVisible(false);
 			boolean temp=gui.znajdz_uzytkownika(login);
 			if(!tfHaslo.isVisible())
 			{
 			if(!tfImie.isVisible())
 			{
  			lLimit.setVisible(true);
 			if(temp==true)
 			{
				lLimit.setText("Ilosc wypozyczonych:"+Integer.toString(gui.get_Limit()));
				przypisz_handler();
 			}
			else
				lLimit.setText("Nie ma takiego u퓓tkownika");
 			}
 			else
 			{
 				if(temp==true)
 				{
 					
 				bZapisz.setVisible(true);
 	 			tfImie.setText(gui.get_imie_Klient());
 				tfNazwisko.setText(gui.get_nazwisko_Klient());
 				tfPesel.setText(gui.get_pesel_Klient());
 				tfMiasto.setText(gui.get_miasto_Klient());
 				tfUlica.setText(gui.get_ulica_Klient());
 				tfKod1.setText(gui.get_kod_Klient().substring(0, 2));
 				tfKod2.setText(gui.get_kod_Klient().substring(2, 5));
 				}
 				else
 				{
 					clear();
 		  			lLimit.setVisible(true);

 					lLimit.setText("Nie ma takiego u퓓tkownika");

 				}

 			}
 			}
 		 
 
 			
		}
		if(e.getSource()==bWyszukajZwrot )
		{
			przypisz_handler();
			String login=tfLoginKlienta.getText();
			lStatus.setVisible(false);
			
 			boolean temp=gui.znajdz_uzytkownika(login);
 			System.out.println(gui.get_imie_Klient());
 			if(!tfHaslo.isVisible())
 			{
 			if(!tfImie.isVisible())
 			{
  			lLimit.setVisible(true);
 			if(temp==true)
 			{
 				przypisz_handler();
 			}
			else
				lLimit.setText("Nie ma takiego u퓓tkownika");
 			}
 			else
 			{
 				if(temp==true)
 				{
 					
 				bZapisz.setVisible(true);
 	 			tfImie.setText(gui.get_imie_Klient());
 				tfNazwisko.setText(gui.get_nazwisko_Klient());
 				tfPesel.setText(gui.get_pesel_Klient());
 				tfMiasto.setText(gui.get_miasto_Klient());
 				tfUlica.setText(gui.get_ulica_Klient());
 				tfKod1.setText(gui.get_kod_Klient().substring(0, 2));
 				tfKod2.setText(gui.get_kod_Klient().substring(2, 5));
 				}
 				else
 				{
 					clear();
 		  			lLimit.setVisible(true);

 					lLimit.setText("Nie ma takiego u퓓tkownika");

 				}

 			}
 			}
 		 
 
 		 
 
 			
		}
		if(e.getSource()==bZatwierdz)
		{
			Ksiazka wypozycz= tvKsiazki.getSelectionModel().getSelectedItem();
			if(wypozycz.getStatus().equals(Status.DOSTEPNA))
			{
				if(gui.get_Limit()<3)
				{
 			gui.dodaj_wypozyczenie(wypozycz);
			lLimit.setText("Ilosc wypozyczonych:"+Integer.toString(gui.get_Limit()));
				}
				else
				{
					lLimit.setText("Limit osiagniety:"+Integer.toString(gui.get_Limit()));

				}
			lStatus.setVisible(false);

			}
			else
				lStatus.setVisible(true);

		}
		if(e.getSource()==bZwrot)
		{
			Ksiazka zwrot=tvKsiazki.getSelectionModel().getSelectedItem();
			gui.przyjmij_zwrot(zwrot);
  			
		}
		if(e.getSource()==bZapisz)
		{
		String imie=tfImie.getText();
		String nazwisko=tfNazwisko.getText();
		String pesel=tfPesel.getText();
		String miasto=tfMiasto.getText();
		String ulica=tfUlica.getText();
		String kod=tfKod1.getText()+tfKod2.getText();
		if(!tfHaslo.isVisible())
		gui.set_klient_all(imie, nazwisko, pesel, miasto, ulica, kod);
		else
		{
			String haslo=tfHaslo.getText();
			gui.set_pracownik_all(imie, nazwisko, pesel, miasto, ulica, kod,haslo);
		}
		}
	}
		public void przypisz_handler()
		{
			EventHandler<ActionEvent> handler=new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent e) {
					if(e.getSource()==bWyszukajKsiazka)
					{
						tytul=tfTytul.getText();
						znalezione=gui.znajdz(tytul);
						tcTytul.setCellValueFactory(new PropertyValueFactory<Ksiazka,String>("tytul"));
						tcAutor.setCellValueFactory(new PropertyValueFactory<Ksiazka,String>("autor"));
						tcStatus.setCellValueFactory(new PropertyValueFactory<Ksiazka,Status>("status"));
						tcLogin.setCellValueFactory(new PropertyValueFactory<Ksiazka,String>("login"));
						tcData_wyp.setCellValueFactory(new PropertyValueFactory<Ksiazka,String>("data_wyp"));
						tcData_zwr.setCellValueFactory(new PropertyValueFactory<Ksiazka,String>("data_zwr"));


						tvKsiazki.setItems(getProduct(znalezione));
						
					}
					if(e.getSource()==bPokaz)
					{
  						tytul=tfTytul.getText();
						znalezione=gui.wypozyczone();
						
					 
						tcTytul.setCellValueFactory(new PropertyValueFactory<Ksiazka,String>("tytul"));
						tcAutor.setCellValueFactory(new PropertyValueFactory<Ksiazka,String>("autor"));
						tcStatus.setCellValueFactory(new PropertyValueFactory<Ksiazka,Status>("status"));
						tcLogin.setCellValueFactory(new PropertyValueFactory<Ksiazka,String>("login"));
						tcData_wyp.setCellValueFactory(new PropertyValueFactory<Ksiazka,String>("data_wyp"));
						tcData_zwr.setCellValueFactory(new PropertyValueFactory<Ksiazka,String>("data_zwr"));


						tvKsiazki.setItems(getProduct(znalezione));
					}
					
				}};
				bWyszukajKsiazka.addEventHandler(ActionEvent.ACTION, handler);
				bPokaz.addEventHandler(ActionEvent.ACTION, handler);
		}
		 
	 }
	

