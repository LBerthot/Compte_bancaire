package fr.afpa21013;

public class Agency {

	private int agencyCode;
	private String agencyAdress;
	private String agencyName;

	public Agency() {
		this.setAgencyCode(agencyCode);
	}

	public Agency(int agencyCode, String agencyAdress, String agencyNameString) {
		super();
		this.setAgencyCode(agencyCode);
		this.setAgencyAdress(agencyAdress);
		this.setAgencyName(agencyNameString);
	}

	@Override
	public String toString() {
		return "Agency [agencyCode=" + agencyCode + ", agencyAdress=" + agencyAdress + ", agencyName=" + agencyName
				+ "]";
	}

	public int getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(int agencyCode) {
		this.agencyCode = agencyCode;
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
