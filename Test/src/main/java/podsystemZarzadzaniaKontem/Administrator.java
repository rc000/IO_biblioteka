package podsystemZarzadzaniaKontem;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Administrator   implements Serializable {
	 
	public String imie,nazwisko;
	String login,haslo;
 
	public Administrator()
	{
	 
	}
	public String getHaslo() {
		return haslo;
	}
	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}
	public void set()
	{
		this.imie="Jan";
		this.nazwisko="Kowalski";
		this.login=this.imie.substring(0,1);
		this.login+=this.nazwisko;
 		this.haslo="1234";
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void zapis_do_pliku()
	{
    try {
     ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("C:\\pliki\\admin.ser")); 
    // tworzymy strumieñ do zapisu i w konstruktorze przekazujemy adres do pliku
    // obiekt FileOutputStream ³¹czy siê z plikiem, a w razie potrzeby tworzy go
    o.writeObject(this); // zapisanie obiektu
    o.close(); // zamkniêcie strumienia
    } catch (Exception ex) {
    ex.printStackTrace();
    }
	}
	public void odczyt_zpliku()throws IOException,ClassNotFoundException
	{
        try{
           ObjectInputStream o =new ObjectInputStream(new FileInputStream("C:\\pliki\\admin.ser"));
           Administrator temp=new Administrator();
           temp.imie="jebac";
           temp=(Administrator)o.readObject();
          
           this.imie=temp.imie;
           this.nazwisko=temp.nazwisko;
           this.login=temp.login;
           this.haslo=temp.haslo;
  

         }catch (EOFException ex) {
            System.out.println("Koniec pliku");
        }
	}
 
	
}
