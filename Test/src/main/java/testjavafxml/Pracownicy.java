package testjavafxml;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Pracownicy implements Serializable{

	public List<Pracownik> lista;
	 private static final long serialVersionUID = 1L;

	public Pracownicy()
	{
		lista=new Vector<Pracownik>();
	}
	
	public void dodaj_pracownika_do_listy(Pracownik p,String imie,String nazwisko,String pesel,String miasto,String ulica,String kod)
	{
		p.add(imie, nazwisko, pesel, miasto, ulica, kod);
		this.lista.add(p);
  	}
	
	public Pracownik wyszukaj(String login)
	{
		for(Pracownik p:this.lista)
		{
			if(login.equals(p.getLogin()))
			{
				return p;

			}
			
		}
		return null;
		//return false;
	}
	public void zapis_do_pliku()
	{
		 try {
 			 

				 ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("C:\\pliki\\workers.ser"));
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
            pl2=new ObjectInputStream(new FileInputStream("C:\\pliki\\workers.ser"));  
          
             lista=(Vector<Pracownik>)pl2.readObject();
 
        } catch (EOFException ex) {
            System.out.println("Koniec pliku");
        }
 
        finally{
            if(pl2!=null)
                pl2.close();
        }
	}
	
}
