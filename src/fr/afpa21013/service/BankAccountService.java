package fr.afpa21013.service;

import fr.afpa21013.BankAccount;
import fr.afpa21013.Client;
import fr.afpa21013.utils.Helpers;

public class BankAccountService {
	private static BankAccount[] bankAccounts;
	
	{
		bankAccounts = new BankAccount[0];
	}

	public BankAccountService() {
		
	}
	
	public BankAccount createAccount() {		
		ClientService cliServ = new ClientService();
		String clientId; 
		//Client client = new Client();
		System.out.println("\n-----Création d'un compte -----\n");		
		System.out.println("Entrez d'abbord le numero de compte du client");
		while(true) {
				System.out.print("Entrez le code du client : ");
				clientId = Helpers.getScanner().nextLine();
				if(this.searchAccount(clientId) == null) {
					break;
				} 			
		}
		System.out.println("Quel compte voulez vous créer : ");
		String accountType = Helpers.getScanner().nextLine();
		System.out.println("Découver autorisé : o/n ");
		String strOverdraft = Helpers.getScanner().nextLine().toUpperCase();		
		boolean overdraft = strOverdraft == "O" ? true : false;
		
		BankAccount account = new BankAccount(1, clientId, 0, overdraft,accountType);
		bankAccounts = Helpers.redimArray(bankAccounts, 1);
		bankAccounts[bankAccounts .length-1] = account; 
		return account;
	}
	
	private BankAccount searchAccount(String countId) {
		if(bankAccounts.length > 0) {	
			for(BankAccount el: bankAccounts) {				
				if(el.getIdAccount().equals(countId)) {
					return el;
				}
			}		
		}
		return null;
	}
	
}
