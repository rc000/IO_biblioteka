package podsystemZarzadzaniaKontem;

 
import java.io.Serializable;

public class Pracownik extends Actor  implements Serializable {
	private static final long serialVersionUID = 1L;

public Pracownik()
{
 super();
			
}
public void add(String imie,String nazwisko,String pesel,String miasto,String ulica,String kod)
{
	super.add(imie,nazwisko,pesel,miasto,ulica,kod);
}
 
	 
}
