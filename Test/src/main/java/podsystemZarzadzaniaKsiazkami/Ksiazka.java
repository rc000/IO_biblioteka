package podsystemZarzadzaniaKsiazkami;

import java.io.Serializable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

 public class Ksiazka implements Serializable{
	private   String  tytul, autor,ISBN,login_klienta;
	private   int  rok_wydania;
	
	private static final long serialVersionUID = 1L;
	
	private   Status status;
	private String login;
	private String data_wyp,data_zwr;
	
	public Ksiazka(String tytul, String autor, String ISBN, String login_klienta, int rok_wydania, Status status) {
		super();
		this.tytul = tytul;
		this.autor = autor;
		this.ISBN = ISBN;
		this.login_klienta = login_klienta;
		this.rok_wydania =rok_wydania;
		this.status = status;
 	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getTytul() {
		return tytul;
	}
	public void setTytul(String tytul) {
		this.tytul = tytul;
	}
	public String getAutor() {
		return autor;
	}
	public void setData_wyp(String data_wyp)
	{
		this.data_wyp=data_wyp;
	}
	public String getData_wyp()
	{
		return this.data_wyp;
	}
	public void setData_zwr(String data_zwr)
	{
		this.data_zwr=data_zwr;
	}
	public String getData_zwr()
	{
		return this.data_zwr;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getLogin_klienta() {
		return login_klienta;
	}
	public void setLogin_klienta(String login_klienta) {
		this.login_klienta = login_klienta;
	}
	public int getRok_wydania() {
		return rok_wydania;
	}
	public void setRok_wydania(int rok_wydania) {
		this.rok_wydania = rok_wydania;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
 }
