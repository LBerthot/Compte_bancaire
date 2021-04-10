package fr.afpa21013;

import java.util.Date;

public class Client {
	private int idClient;
	private String name;
	private String firstName;
	private Date birthDate;
	private String email;
	private String telephon;
	private int idAccount;
	
	
	
	public Client() {	
	}

	public Client(String nom, String prenom, Date birthDate, String email, String telephon, int idAccount) {
		super();
		this.name = nom;
		this.firstName = prenom;
		this.birthDate = birthDate;
		this.email = email;
		this.telephon = telephon;
		this.idAccount = idAccount;
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
	public int getIdAccount() {
		return idAccount;
	}
	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}
	public int getIdClient() {
		return idClient;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nom=" + name + ", prenom=" + firstName + ", birthDate=" + birthDate
				+ ", email=" + email + ", telephon=" + telephon + ", idAccount=" + idAccount + "]";
	}			
}
