package fr.afpa21013;

import java.util.Date;
import java.util.Random;

public class Client {
	private String idClient;
	private String name;
	private String firstName;
	private Date birthDate;
	private String adress;
	private String email;
	private String telephon;
	private String idAccount;

	public Client() {
		this.setIdClient();
	}

	public Client(String name, String firstName, String adress, Date birthDate, String email, String telephon,
			String idAccount) {
		this.setIdClient();
		this.name = name;
		this.firstName = firstName;
		this.birthDate = birthDate;
		this.adress = adress;
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

	public void setIdClient() {
		Random rand = new Random();
		String id = "";
		id = "";
		for (int j = 0; j < 2; j++) {
			char c = (char) (rand.nextInt(26) + 65);
			id += c;
		}
		id += rand.nextInt(999999);
		this.idClient = id;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nom=" + name + ", prenom=" + firstName + ", birthDate=" + birthDate
				+ ", email=" + email + ", telephon=" + telephon + ", idAccount=" + idAccount + "]";
	}
}
