package fr.afpa21013.tests;

import fr.afpa21013.Agency;
import fr.afpa21013.BankAccount;
import fr.afpa21013.Client;
import fr.afpa21013.service.AgencyService;
import fr.afpa21013.service.BankAccountService;
import fr.afpa21013.service.ClientService;
import fr.afpa21013.utils.Helpers;


public class TestVincent {	
	
	public TestVincent() {
	//	ServicesDto servDto = new ServicesDto();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createAgency();
		testCreeCli();
		//searchClient();		
//		testCreeCli();
		testCreeAccount();
//		testSearchAccount();
		testAffiche();
	}
	
	public static void testCreeCli() {
		ClientService cliServe = ClientService.getClientService();// cr�ation		
		Client c2 = cliServe.createClient();
		//Client c3 = cliServe.createClient();
		
	}
	
	public static void createAgency() {
		AgencyService agencyServ = AgencyService.getAgencyService();
		Agency  agen = agencyServ.createAgency();
	}
	
	
	public static void testCreeAccount() {
		ClientService cliServe = ClientService.getClientService();
		//if(ClientService.clients.length > 0 && AgencyService.agencies.length >0) {
			BankAccountService account = BankAccountService.getAccountService();
			account.createAccount();
			for(BankAccount el : BankAccountService.bankAccounts) {
				System.out.println(el);
			}			
//		}else {
//			System.out.println("Aucun client cr�� dans la base\nCommencez par en cr�er un!!");
//		}		
	}
	public static void testSearchAccount() {
		BankAccountService accountServ = BankAccountService.getAccountService();
		BankAccount account = accountServ.searchAccount();
		if(account != null) {
			System.out.println("compte trouve "+ account);
		}
	}
	
	public static void searchClient() {
		ClientService cliServe = ClientService.getClientService();
		System.out.println("id du compte ?");
		String idCl = Helpers.getScanner().nextLine();
		cliServe.searchClient(idCl,"idCli");
	}
	
	public static void testAffiche() {
		ClientService cliServe = ClientService.getClientService();
		cliServe.displayClientCountList();
	}
}




