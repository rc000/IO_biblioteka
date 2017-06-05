package testjavafxml;

import java.io.Serializable;

public class Actor implements Serializable {

	protected String imie,nazwisko,login,haslo,pesel,miasto,ulica,kod;

	private static final long serialVersionUID = 1L;

	public Actor()
	{
		imie="brak";
		nazwisko="brak";
		login="brak";
		haslo="brak";
		pesel="brak";
		miasto="brak";
		ulica="brak";
		kod="brak";
	}
	public String getImie() {
		return imie;
	}
	public void generateLogin()
	{
		this.login=imie.substring(0, 1);
		this.login+=this.nazwisko;
	}
	public void generateHaslo()
	{
		this.haslo+=this.pesel.substring(0, 2);
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
	public String getHaslo() {
		return haslo;
	}
	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}
	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	public String getMiasto() {
		return miasto;
	}
	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public String getKod() {
		return kod;
	}
	public void setKod(String kod) {
		this.kod = kod;
	}
	public void add(String imie,String nazwisko,String pesel,String miasto,String ulica,String kod)
	{
		
		this.imie=imie;
		this.nazwisko=nazwisko;
		this.login=this.imie.substring(0,1);
		this.login+=this.nazwisko;
		this.pesel=pesel;

		this.haslo=this.login+this.pesel.substring(0,2);
		this.miasto=miasto;
		this.ulica=ulica;
		this.kod=kod;
	}
}
