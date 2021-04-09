package fr.afpa21013;

import java.util.Random;

public class Agency {

	private int agencyCode;
	private String agencyAdress;
	private String agencyName;

	public Agency() {
		this.setAgencyCode();
	}

	public Agency(String agencyAdress, String agencyName) {
		super();
		this.setAgencyCode();
		this.setAgencyAdress(agencyAdress);
		this.setAgencyName(agencyName);
	}

	@Override
	public String toString() {
		return "Agency [agencyCode=" + agencyCode + ", agencyAdress=" + agencyAdress + ", agencyName=" + agencyName
				+ "]";
	}

	public int getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode() {
		Random rn = new Random();
		this.agencyCode = rn.nextInt(1000);
	}

	public String getAgencyAdress() {
		return agencyAdress;
	}

	public void setAgencyAdress(String agencyAdress) {
		this.agencyAdress = agencyAdress;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

}
