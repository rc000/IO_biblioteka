package testjavafxml;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;

public class Klienci implements Serializable {
	public List<Klient> lista;
	private static final long serialVersionUID = 1L;
	public Klienci()
	{
		lista=new Vector<Klient>();
	}
	void dodaj_do_listy(String imie,String nazwisko,String pesel,String miasto,String ulica,String kod)
	{
		Klient k=new Klient();
		k.add(imie, nazwisko, pesel, miasto, ulica, kod);
		this.lista.add(k);
  	}
	
	public Klient wyszukaj(String login)
	{
		for(Klient k:this.lista)
		{
			if(login.equals(k.getLogin()))
			{
	 
				return k;

			}
		 
			
		}
		return null;
		//return false;
	}
	public void zapis_do_pliku()
	{
	 
		 try {
 			 

				 ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("C:\\pliki\\users.ser"));
				 o.writeObject(this.lista); // zapisanie obiektu
				 o.close(); // zamkniêcie strumienia
			 
		 // tworzymy strumieñ do zapisu i w konstruktorze przekazujemy adres do pliku
		 // obiekt FileOutputStream ³¹czy siê z plikiem, a w razie potrzeby tworzy go
		 
		 } catch (Exception ex) {
		 ex.printStackTrace();
		 }
	}
	public void wczytaj() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		ObjectInputStream pl2=null;
         try{
            pl2=new ObjectInputStream(new FileInputStream("C:\\pliki\\users.ser"));  
          
             lista=(Vector<Klient>)pl2.readObject();
 
        } catch (EOFException ex) {
            System.out.println("Koniec pliku");
        }
 
        finally{
            if(pl2!=null)
                pl2.close();
        }
	}
}
