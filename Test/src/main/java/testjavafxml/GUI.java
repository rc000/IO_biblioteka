package testjavafxml;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GUI {
	private Administrator admin;
	private Pracownicy pracownicy;
	private Klienci klienci;
	private Klient klient;
	private static GUI instance;
	public Ksiazki ksiazki;
	private Pracownik pracownik;
	private GUI()
	{
	

	}
    public static GUI getInstance() {
        if (instance == null) {
            instance = new GUI();
            
        }
        
        return instance;
    }
	public void wczytaj()
	{
		admin=new Administrator();
		pracownicy=new Pracownicy();
		klienci=new Klienci();
		klient=new Klient();
		ksiazki=new Ksiazki();
		pracownik=new Pracownik();
		try {
			admin.odczyt_zpliku();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.pracownicy.wczytaj();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.klienci.wczytaj();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.ksiazki.wczytaj();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean zaloguj_admin(String login,String password)  
	{

		if(login.equals(admin.login))
		{
			if(password.equals(admin.haslo))
			{
 					return true;

			}
			else return false;
		}
		else return false;
		
	}

//Gettery i settery
	public Administrator getAdmin() {
		return admin;
	}
	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}
	public Pracownicy getPracownicy() {
		return pracownicy;
	}
	public void setPracownicy(Pracownicy pracownicy) {
		this.pracownicy = pracownicy;
	}
	public Klienci getKlienci() {
		return klienci;
	}
	public void setKlienci(Klienci klienci) {
		this.klienci = klienci;
	}
	public Klient getKlient() {
		return klient;
	}
	public void setKlient(Klient klient) {
		this.klient = klient;
	}
	public Ksiazki getKsiazki() {
		return ksiazki;
	}
	public void setKsiazki(Ksiazki ksiazki) {
		this.ksiazki = ksiazki;
	}
	public Pracownik getPracownik() {
		return pracownik;
	}
	public void setPracownik(Pracownik pracownik) {
		this.pracownik = pracownik;
	}
	public String get_imie_Klient()
	{
		return this.klient.getImie();
	}
	public String get_haslo_Klient()
	{
		return this.klient.getHaslo();
	}
	public String get_nazwisko_Klient()
	{
		return this.klient.getNazwisko();
	}
	
	public String get_pesel_Klient()
	{
		return this.klient.getPesel();
	}
	public String get_miasto_Klient()
	{
		return this.klient.getMiasto();
	}
	public String get_ulica_Klient()
	{
		return this.klient.getUlica();
	}
	public String get_kod_Klient()
	{
		return this.klient.getKod();
	}
	public int get_Limit()
	{
		return this.klient.getLimit();
	}
	public void set_klient_all(String imie,String nazwisko,String pesel,String miasto,String ulica,String kod)
	{
 		this.klient.setImie(imie);
 
		this.klient.setNazwisko(nazwisko);
		this.klient.setPesel(pesel);
		this.klient.setMiasto(miasto);
		this.klient.setUlica(ulica);
		this.klient.setKod(kod);
		this.klient.generateLogin();
		this.klient.generateHaslo();
		zapisz();
	}
	public String get_imie_Pracownik()
	{
		return this.pracownik.getImie();
	}
	public String get_nazwisko_Pracownik()
	{
		return this.pracownik.getNazwisko();
	}
	
	public String get_pesel_Pracownik()
	{
		return this.pracownik.getPesel();
	}
	public String get_miasto_Pracownik()
	{
		return this.pracownik.getMiasto();
	}
	public String get_ulica_Pracownik()
	{
		return this.pracownik.getUlica();
	}
	public String get_kod_Pracownik()
	{
		return this.pracownik.getKod();
	}
	public String get_haslo_Pracownik()
	{
		return this.pracownik.getHaslo();
	}
	public void set_pracownik_all(String imie,String nazwisko,String pesel,String miasto,String ulica,String kod,String haslo)
	{
		this.pracownik.setImie(imie);
		this.pracownik.setNazwisko(nazwisko);
		this.pracownik.setPesel(pesel);
		this.pracownik.setMiasto(miasto);
		this.pracownik.setUlica(ulica);
		this.pracownik.setKod(kod);
		
		this.pracownik.generateLogin();
		this.pracownik.setHaslo(haslo);
		zapisz();

	}
	//Logowanie
	public boolean zaloguj_pracownik(String login,String password)  
	{
		Pracownik temp=this.pracownicy.wyszukaj(login);
		if(temp!=null)
		{
				if(password.equals(temp.getHaslo()))
			{
				this.pracownik=temp;
				return true;
			}
		else return false;
		}
		else return false;
		
	}
	public boolean zaloguj_uzytkownik(String login,String password)  

	{
	
	Klient temp=this.klienci.wyszukaj(login);
	if(temp!=null)
	{
			if(password.equals(temp.getHaslo()))
		{
			this.klient=temp;
			return true;
		}
	else return false;
	}
	else return false;
	
	}
	//dodawanie obiektow
	public void dodaj_pracownika(String imie,String nazwisko,String pesel,String miasto,String ulica,String kod)
	{
 		this.pracownicy.dodaj_pracownika_do_listy(pracownik,imie,nazwisko,pesel,miasto,ulica,kod);
		this.pracownicy.zapis_do_pliku();
	}
	public void dodaj_uzytkownika(String imie,String nazwisko,String pesel,String miasto,String ulica,String kod)
	{
  		this.klienci.dodaj_do_listy(imie,nazwisko,pesel,miasto,ulica,kod);
		this.klienci.zapis_do_pliku();
	}
	public void dodaj_ksiazke(String tytul,String autor,String ISBN,int rok)
	{
  		this.ksiazki.dodaj_do_listy(tytul, autor, ISBN, rok,"brak");
		this.ksiazki.zapis_do_pliku();
	}
	//wyszukiwanie
	public boolean znajdz_uzytkownika(String login)
	{
		this.klient=klienci.wyszukaj(login);
		if(klient!=null)
			return true;
		else
			return false;
	}
	
	 public List<Ksiazka> znajdz (String tytul)
	 {
		 List<Ksiazka> znalezione=new Vector<Ksiazka>();
		 znalezione=this.ksiazki.znajdz(tytul);
		 return znalezione;
	 }
	 public List<Ksiazka> wypozyczone ()
	 {
		 List<Ksiazka> znalezione=new Vector<Ksiazka>();
		 znalezione=this.klient.getLista();
		 return znalezione;
	 }
	 public List <Ksiazka> zarezerwowane()
	 {
		 List<Ksiazka> znalezione=new Vector<Ksiazka>();
		 for(Ksiazka k:ksiazki.lista)
		 {
			 if(k.getStatus().equals(Status.REZERWACJA))
			 {
				 if(k.getLogin().equals(this.klient.getLogin()))
				 {
					 znalezione.add(k);
				 }
				 else 
					 continue;
			 }
			 else continue;
		 }
		 return znalezione;
	 }
	 public void zapisz()
	 {
		 this.klienci.zapis_do_pliku();
		 this.ksiazki.zapis_do_pliku();
		 this.pracownicy.zapis_do_pliku();
	 }
	public void dodaj_wypozyczenie(Ksiazka k) throws IOException
	{
		this.klient.dodaj_wypozyczenie(k);
		//k.setStatus(Status.WYPOZYCZONA);
		this.zapisz();
 	}
	public void przyjmij_zwrot (Ksiazka k) throws IOException
	{
		
		this.klient.przyjmij_zwrot(k);
		k.setStatus(Status.DOSTEPNA);
		this.zapisz();
	}
	public void wyswietl_wypozyczenia()
	{
		this.klient.wyswietl_wypozyczone();
	}
}
	

