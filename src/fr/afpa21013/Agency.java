package fr.afpa21013;

import fr.afpa21013.utils.Helpers;

public class Agency {

	private final long limit = 1000l;
	
	private long agencyCode;
	private String agencyAdress;
	private String agencyName;

	public Agency() {
		this.agencyCode = Helpers.SetCode(limit);
	}

	public Agency(String agencyAdress, String agencyName) {
		this.setAgencyAdress(agencyAdress);
		this.setAgencyName(agencyName);
	}

	@Override
	public String toString() {
		return "Agency [agencyCode=" + agencyCode + ", agencyAdress=" + agencyAdress + ", agencyName=" + agencyName
				+ "]";
	}

	public long getAgencyCode() {
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
