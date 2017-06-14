package podsystemZarzadzaniaKontem;
   import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import podsystemWypozyczen.Wypozyczenia;
import podsystemZarzadzaniaKsiazkami.Ksiazka;
import podsystemZarzadzaniaKsiazkami.Status;

public class Klient extends Actor implements Serializable {
 
 	private int limit;
 	private Wypozyczenia lista;
	private static final long serialVersionUID = 1L;

 	public Klient ()
	{
		super();
 		lista=new Wypozyczenia();
 	}

	 
	public List<Ksiazka> getLista() {
 		return lista.getLista();
	}
  


	public void setLista(Wypozyczenia lista) {
		this.lista = lista;
	}



	public void dodaj_wypozyczenie(Ksiazka k) throws IOException
 	{
 		this.lista.dodaj_do_listy(k,this.login);
 		limit++;
 		//this.lista.zapis_do_pliku(this.login);
 	}
	public void przyjmij_zwrot(Ksiazka k) throws IOException
	{
		limit--;
		this.lista.usun_zlisty(k);
		k.setStatus(Status.DOSTEPNA);
		
	}
  
	public int getLimit() {
		return limit;
	}

	
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	public void add(String imie,String nazwisko,String pesel,String miasto,String ulica,String kod )
	{
		super.add(imie, nazwisko, pesel, miasto, ulica, kod);
  	}

	
}
