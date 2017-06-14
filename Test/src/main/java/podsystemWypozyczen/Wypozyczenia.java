package podsystemWypozyczen;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;

import podsystemZarzadzaniaKsiazkami.Ksiazka;

public class Wypozyczenia implements Serializable{
	List<Wypozyczenie> lista;
	String nazwa;
	private static final long serialVersionUID = 1L;
	public Wypozyczenia()
	{
		lista=new Vector<Wypozyczenie>();
		nazwa="brak";
	}
	public List<Ksiazka> getLista() {
		List<Ksiazka> temp =new Vector<Ksiazka>();
 		for (Wypozyczenie w:lista)
		{
			temp.add(w.getK());
 		}
		
		return temp;
	}
	public void setLista(List<Wypozyczenie> lista) {
		this.lista = lista;
	}
	public void dodaj_do_listy(Ksiazka k,String login)
	{
		Wypozyczenie wyp=new Wypozyczenie();
		wyp.dodaj(k,login);
		this.lista.add(wyp);
   	}
public void usun_zlisty(Ksiazka k)
{
	Wypozyczenie w;
	for (Wypozyczenie w1:this.lista)
	{
		if(w1.getK().equals(k))
		{
			w=w1;
			w.usun(k);
			this.lista.remove(w);
 			
			break;
		}
	}
}
 
	public void zapis_do_pliku(String login) throws IOException
	{
		this.nazwa="C:\\pliki\\"+login+"loans.ser";
	      File file = new File(nazwa);
	      if (!file.exists())
	      {
	    	  file.createNewFile();
	      }
 
		 try {
 			 

				 ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("nazwa"));
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
            pl2=new ObjectInputStream(new FileInputStream("nazwa"));  
          
             lista=(Vector<Wypozyczenie>)pl2.readObject();
 
        } catch (EOFException ex) {
            System.out.println("Koniec pliku");
        }
 
        finally{
            if(pl2!=null)
                pl2.close();
        }
	}
}
