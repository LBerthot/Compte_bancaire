package fr.afpa21013.service;

import fr.afpa21013.BankAccount;
import fr.afpa21013.Client;
import fr.afpa21013.utils.Helpers;

public class BankAccountService {

	private static BankAccountService bankAccountService;
	public static BankAccount[] bankAccounts;

	public BankAccountService() {
	}

	public static BankAccountService getAccountService() {
		if (bankAccountService == null) {
			bankAccountService = new BankAccountService();
			bankAccounts = new BankAccount[0];

		}
		return bankAccountService;
	}

	public BankAccount createAccount() {
		String clientId;
		String accountType;
		boolean overdraft = false;
		// AgencyService agencyService =
		ClientService cliServ = ClientService.getClientService();// pour acces methode searchClient
		AgencyService agencyService = AgencyService.getAgencyService();
		// Client client = new Client();
		System.out.println("\n-----Création d'un compte -----\n");

		String agencyId = agencyService.selectAgency();

		while (true) {
			System.out.print("Entrez le code du client : ");// verif existance client
			clientId = Helpers.getScanner().nextLine();
			if (cliServ.searchClient(clientId, "idCli") != null) {
				break;
			} else {
				System.out.println("Client inexistant !\n");
			}

		}
		while (true) {
			System.out.println ("Quel compte voulez vous créer (courant/livretA/pel : ");
			accountType = Helpers.getScanner().nextLine().toUpperCase();
			if (testTypeCompte(accountType) && testNbCpt(clientId,accountType)) {
				break;
			}
			System.out.println("Ce type de compte est inexistant ou compte dépassant la limite autorisée ..");
		}
		if(!(accountType.equals("PEL") || accountType.equals("LIVRETA"))) {
			System.out.println("Découver autorisé : o/n ");
			String strOverdraft = Helpers.getScanner().nextLine().toUpperCase();
			overdraft = strOverdraft.equals("O") ? true : false;			
		}


		BankAccount account = new BankAccount(agencyId, clientId, 0, overdraft, accountType);
		Client client = cliServ.searchClient(clientId, "idCli");
		client.setIdAccount(account.getIdAccount());

		bankAccounts = Helpers.redimArray(bankAccounts, 1);
		bankAccounts[bankAccounts.length - 1] = account;

		Helpers.clearScreen();
		System.out.println("\nLe compte " + account.getAccountType() + " numéro "+ account.getIdAccount() + " a été créée avec succès.\n");
		System.out.println("\nAppuyer sur entrer pour retourner au menu principal...");
		return account;
	}

	public BankAccount searchAccount() {
		if (bankAccounts.length > 0) {
			System.out.println("\n-----Recherche d'un compte par numero -----\n");
			System.out.println("numéro de compte ? ");// test type de compte
			String accountId = Helpers.getScanner().nextLine();
			for (BankAccount el : bankAccounts) {
				if (el.getIdAccount().equals(accountId)) {
					System.out.println("Le compte " + el.getAccountType() + " numéro " + el.getIdAccount() + " a un solde de " + el.getSold());
					return el;
				}
			}System.out.println("Numero de compte invalide !");
		} else {
			System.out.println("compte inexistant !");
		}
		return null;
	}

	private boolean testTypeCompte(String typeAccount) {
		return (typeAccount.equals("COURANT") || typeAccount.equals("LIVRETA") || typeAccount.equals("PEL"));
	}

	private boolean testNbCpt(String idCli,String typeCpt) {		
		int nbCpt,nbCptCourant,nbLivretA;
		nbCpt = nbCptCourant = nbLivretA =0;
		for(BankAccount cont: bankAccounts) {
			if(cont.getClientCode().equals(idCli)) {
				if(typeCpt.equals("COURANT")) {
					nbCptCourant++;	
				} else if(typeCpt.equals("PEL"))
				{nbCpt++;}else {nbLivretA++;}
				
			}
		}
		return !(nbLivretA >= 1 && typeCpt.equals("LIVRETA") || nbCpt >= 1 && typeCpt.equals("PEL") || typeCpt.equals("COURANT") && nbCptCourant >= 3);
	}
}
