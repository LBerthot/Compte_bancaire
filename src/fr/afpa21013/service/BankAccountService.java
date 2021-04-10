package fr.afpa21013.service;

import fr.afpa21013.BankAccount;
import fr.afpa21013.Client;
import fr.afpa21013.utils.Helpers;

public class BankAccountService {
	private static BankAccount[] bankAccount;
	
	{
		bankAccount = new BankAccount[0];
	}

	public BankAccountService() {
		
	}
	
	public BankAccount createAccount() {
		BankAccount account = new BankAccount();
		ClientService cliServ = new ClientService();
		String name,firstName; 
		Client client = new Client();
		System.out.println("\n-----Création d'un compte -----\n");		
		System.out.println("Entrez d'abbord le numero de compte du client");
		
		
		return null;
	}
}
