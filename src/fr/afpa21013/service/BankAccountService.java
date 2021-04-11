package fr.afpa21013.service;

import fr.afpa21013.BankAccount;
import fr.afpa21013.utils.Helpers;

public class BankAccountService {

	private static BankAccountService bankAccountService;

	private final int limit = 11;

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
			System.out.println("Quel compte voulez vous créer : ");// test type de compte
			accountType = Helpers.getScanner().nextLine().toUpperCase();
			if (testTypeCompte(accountType)) {
				break;
			}
			System.out.println("Ce type de compte est inexistant..");
		}

		System.out.println("Découver autorisé : o/n ");
		String strOverdraft = Helpers.getScanner().nextLine().toUpperCase();
		boolean overdraft = strOverdraft.equals("O") ? true : false;

		BankAccount account = new BankAccount(agencyId, clientId, 0, overdraft, accountType);

		bankAccounts = Helpers.redimArray(bankAccounts, 1);
		bankAccounts[bankAccounts.length - 1] = account;
		return account;
	}

	public BankAccount searchAccount() {
		if (bankAccounts.length > 0) {
			System.out.println("\n-----Recherche d'un compte par numero -----\n");
			System.out.println("numéro de compte ? ");// test type de compte
			String accountId = Helpers.getScanner().nextLine();
			for (BankAccount el : bankAccounts) {
				if (el.getIdAccount().equals(accountId)) {
					return el;
				}
			}
		} else {
			System.out.println("compte inexistant !");
		}
		return null;
	}

	private boolean testTypeCompte(String typeAccount) {
		return (typeAccount.equals("COURANT") || typeAccount.equals("LIVRETA") || typeAccount.equals("PEL"));
	}

}
