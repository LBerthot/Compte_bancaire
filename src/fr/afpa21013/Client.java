package fr.afpa21013;

import java.util.Date;

import fr.afpa21013.utils.Helpers;

public class Client {

	private final int limit = 6;
	private String idClient;
	private String name;
	private String firstName;
	private Date birthDate;
	private String adress;
	private String email;
	private String telephon;
	private String idAccount;

	public Client() {

	}

	public Client(String name, String firstName, String adress, Date birthDate, String email, String telephon) {
		this.name = name;
		this.firstName = firstName;
		this.birthDate = birthDate;
		this.adress = adress;
		this.email = email;
		this.telephon = telephon;
		idClient = name.substring(0, 1) + firstName.substring(0, 1) + Helpers.SetCode(limit);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephon() {
		return telephon;
	}

	public void setTelephon(String telephon) {
		this.telephon = telephon;
	}

	public String getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(String idAccount) {
		this.idAccount = idAccount;
	}

	public String getIdClient() {
		return idClient;
	}

	@Override
	public String toString() {
		return "\n	info client : \nNuméro client : " + this.idClient + "\nNom : " + this.name + "\nPrénom : " + this.firstName + "\nDate de naissance : " + this.birthDate;
	}
}