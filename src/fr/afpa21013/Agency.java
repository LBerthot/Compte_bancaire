package fr.afpa21013;

import fr.afpa21013.utils.Helpers;

public class Agency {

	private final int limit = 3;
	
	private String agencyCode;
	private String agencyAdress;
	private String agencyName;

	public Agency() {
		this.agencyCode = Helpers.SetCode(limit);
	}

	public Agency(String agencyAdress, String agencyName) {
		this.agencyCode =  Helpers.SetCode(limit);
		this.setAgencyAdress(agencyAdress);
		this.setAgencyName(agencyName);		
	}

	@Override
	public String toString() {
		return "Agency [agencyCode=" + agencyCode + ", agencyAdress=" + agencyAdress + ", agencyName=" + agencyName
				+ "]";
	}

	public String getAgencyCode() {
		return agencyCode;
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
