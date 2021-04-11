package fr.afpa21013.tests;

import fr.afpa21013.BankAccount;
import fr.afpa21013.Client;
import fr.afpa21013.service.BankAccountService;
import fr.afpa21013.service.ClientService;


public class TestVincent {	
	
	public TestVincent() {
	//	ServicesDto servDto = new ServicesDto();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testCreeCli();
		testCreeAccount();
		testCreeAccount();
	}
	
	public static void testCreeCli() {
		ClientService cliServe = ClientService.getClientService();// création
		Client c1 = cliServe.createClient();
		Client c2 = cliServe.createClient();
		
	}
	
	public static void testCreeAccount() {
		ClientService cliServe = new ClientService();
		//if(ClientService.clients.length > 0) {
			BankAccountService account = new BankAccountService();
			account.createAccount();
			for(BankAccount el : BankAccountService.bankAccounts) {
				System.out.println(el);
			}			
//		}else {
//			System.out.println("Aucun client créé dans la base\nCommencez par en créer un!!");
//		}		
	}
}
