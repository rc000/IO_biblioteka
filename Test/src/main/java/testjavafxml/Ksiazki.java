package testjavafxml;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Vector;

public class Ksiazki {
	List<Ksiazka> lista;
	private static final long serialVersionUID = 1L;
	public Ksiazki()
	{
		lista=new Vector<Ksiazka>();
	}
	void dodaj_do_listy(String tytul,String autor,String ISBN,int rok,String login)
	{
		Ksiazka k=new Ksiazka(tytul, autor, ISBN, login, rok,Status.DOSTEPNA);
 		this.lista.add(k);
  	}

	public void zapis_do_pliku()
	{
 
		 try {
 			 

				 ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("C:\\pliki\\books.ser"));
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
            pl2=new ObjectInputStream(new FileInputStream("C:\\pliki\\books.ser"));  
          
             lista=(Vector<Ksiazka>)pl2.readObject();
 
        } catch (EOFException ex) {
            System.out.println("Koniec pliku");
        }
 
        finally{
            if(pl2!=null)
                pl2.close();
        }
	}
	
	 public List<Ksiazka> znajdz (String tytul)
	 {
		 int licznik_znakow=0;
		 String temp;
		 List<Ksiazka> znalezione=new Vector<Ksiazka>();
		 for(Ksiazka k:this.lista)
		 {
			 temp=k.getTytul();
			 for (int i=0;i<tytul.length();i++)
			 {
				 if(tytul.charAt(i)==temp.charAt(i))
				 licznik_znakow++;
				 else
				licznik_znakow=0;
			 }
			 if (licznik_znakow>2)
				 znalezione.add(k);
		 }
		 return znalezione;
	 }
}
