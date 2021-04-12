package fr.afpa21013;

import java.util.Random;

import fr.afpa21013.utils.Helpers;

public class BankAccount {
	
	private final int  code = 11;

	private String idAccount;
	private long agencyCode;
	private String clientCode;
	private double sold;
	private boolean authorisedOverdraft;
	private String accountType;

	public BankAccount() {
		this.idAccount = Helpers.SetCode(code);
	}

	public BankAccount(String agencyCode, String clientCode, boolean authorisedOverdraft,
			String accountType) {
		this.idAccount = Helpers.SetCode(code);
		this.setClientCode(clientCode); // Use .getClientCode
		this.setSold(generateAleat());
		this.setAuthorisedOverdraft(authorisedOverdraft);
		this.setAccountType(accountType);
	}

	@Override
	public String toString() {
		return "BankAccount [idAccount=" + idAccount + ", agencyCode=" + agencyCode + ", clientCode=" + clientCode
				+ ", sold=" + sold + ", authorisedOverdraft=" + authorisedOverdraft + ", accountType=" + accountType
				+ "]";
	}

	public String getIdAccount() {
		return idAccount;
	}

	
	public String getClientCode() {
		return clientCode;
	}

	public long getAgencyCode() {
		return agencyCode;
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

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	
	private double generateAleat() {
		Random rd = new Random();
		return 5000+ rd.nextDouble() *(10000+5000);
	}
}
