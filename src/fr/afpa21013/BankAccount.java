package fr.afpa21013;

public class BankAccount {

	private int idAccount;
	private int agencyCode;
	private String clientCode;
	private double sold;
	private boolean authorisedOverdraft;
	private String accountType;

	public BankAccount() {
		this.setIdAccount(idAccount);
	}

	public BankAccount(int agencyCode, String clientCode, double sold, boolean authorisedOverdraft,
			String accountType) {
		this.setIdAccount(agencyCode);
		this.setAgencyCode(agencyCode); // Use .getAgencyCode
		this.setClientCode(clientCode); // Use .getClientCode
		this.setSold(sold);
		this.setAuthorisedOverdraft(authorisedOverdraft);
		this.setAccountType(accountType);
	}

	@Override
	public String toString() {
		return "BankAccount [idAccount=" + idAccount + ", agencyCode=" + agencyCode + ", clientCode=" + clientCode
				+ ", sold=" + sold + ", authorisedOverdraft=" + authorisedOverdraft + ", accountType=" + accountType
				+ "]";
	}

	public int getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	public int getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(int agencyCode) { // Use .getAgencyCode
		this.agencyCode = agencyCode;
	}

	public double getSold() {
		return sold;
	}

	public void setSold(double sold) {
		this.sold = sold;
	}

	public boolean isAuthorisedOverdraft() {
		return authorisedOverdraft;
	}

	public void setAuthorisedOverdraft(boolean authorisedOverdraft) {
		this.authorisedOverdraft = authorisedOverdraft;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) { // Use .getClientCode
		this.clientCode = clientCode;
	}

}
