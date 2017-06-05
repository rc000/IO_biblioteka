package testjavafxml;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

 
public class Wypozyczenie implements Serializable {
Ksiazka k;
Date data_wypozyczenia;
Date data_zwrotu;
SimpleDateFormat format;
private static final long serialVersionUID = 1L;

public Ksiazka getK() {
	return k;
}
public void setK(Ksiazka k) {
	this.k = k;
}
public Wypozyczenie()
{
	k=new Ksiazka("brak", "brak", "brak","brak", 0, Status.WYPOZYCZONA);
	data_wypozyczenia=new Date();
	   format = new SimpleDateFormat ("dd.MM.yyyy ");

 	
	
}
public void wyswietl()
{
	System.out.println(this.k.getTytul());
	System.out.println(data_wypozyczenia.toString());
}
public void dodaj(Ksiazka k,String login)
{
	this.k=k;
	this.k.setLogin(login);
	this.k.setStatus(Status.WYPOZYCZONA);
	this.k.setData_wyp(format.format(data_wypozyczenia));
	Calendar c = Calendar.getInstance();
	c.setTime(data_wypozyczenia);
	c.add(Calendar.DATE, 14);  // number of days to add
	 data_zwrotu=c.getTime();
	this.k.setData_zwr(format.format(data_zwrotu));
}

public void usun(Ksiazka k)
{
	this.k=k;
	this.k.setStatus(Status.DOSTEPNA);
	this.k.setLogin(null);
	this.k.setData_wyp(null);
	this.k.setData_zwr(null);
 }
}