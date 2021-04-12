package fr.afpa21013.service;

import fr.afpa21013.BankAccount;
import fr.afpa21013.Client;
import fr.afpa21013.utils.Helpers;

public class BankAccountService {

	private static BankAccountService bankAccountService;
	public static BankAccount[] bankAccounts;
	private int[] arrCpteur = new int[3];

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
		ClientService cliServ = ClientService.getClientService();// To create searchClient method
		AgencyService agencyService = AgencyService.getAgencyService();
		System.out.println("\n-----Création d'un compte -----\n");

		String agencyId = agencyService.selectAgency();
		while (true) {
			System.out.print("Entrez le code du client : ");// Check the client existence
			clientId = Helpers.getScanner().nextLine();
			if (cliServ.searchClient(clientId, "idCli") != null) {
				break;
			} else {
				System.out.println("Client inexistant !\n");
			}
		}

		// boolean notOver = true;
		while (true) {
			System.out.println("Quel compte voulez vous créer (courant/livretA/pel : ");
			accountType = Helpers.getScanner().nextLine().toUpperCase();
			// notOver = testNbCpt(clientId,accountType,arrCpteur);
			if (testTypeCompte(accountType)) {
				break;
			}
			System.out.println("Ce type de compte est inexistant ou compte dépassant la limite autorisée ..");
//			if(arrCpteur[0] > 2) {arrCpteur[0] = 0;}
//			if(arrCpteur[1] > 0) {arrCpteur[1] = 0;}
//			if(arrCpteur[2] > 0) {arrCpteur[2] = 0;}
		}
		if (!(accountType.equals("PEL") || accountType.equals("LIVRETA"))) {
			System.out.println("Découver autorisé : o/n ");
			String strOverdraft = Helpers.getScanner().nextLine().toUpperCase();
			overdraft = strOverdraft.equals("O") ? true : false;
		}

		BankAccount account = new BankAccount(agencyId, clientId, overdraft, accountType);
		Client client = cliServ.searchClient(clientId, "idCli");
		client.setIdAccount(account.getIdAccount());

		bankAccounts = Helpers.redimArray(bankAccounts, 1);
		bankAccounts[bankAccounts.length - 1] = account;

		Helpers.clearScreen();
		System.out.println("\nLe compte " + account.getAccountType() + " numéro " + account.getIdAccount()
				+ " a été créée avec succès.\n");
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
					System.out.println("Le compte " + el.getAccountType() + " numéro " + el.getIdAccount()
							+ " a un solde de " + el.getSold());
					return el;
				}
			}
			System.out.println("Numero de compte invalide !");
		} else {
			System.out.println("compte inexistant !");
		}
		return null;
	}

	private boolean testTypeCompte(String typeAccount) {
		return (typeAccount.equals("COURANT") || typeAccount.equals("LIVRETA") || typeAccount.equals("PEL"));
	}

	private boolean testNbCpt(String idCli, String typeCpt, int[] arrCpt) {
		for (BankAccount cont : bankAccounts) {
			if (cont.getClientCode().equals(idCli)) {
				if (typeCpt.equals("COURANT")) {
					arrCpt[0]++;
				} else if (typeCpt.equals("PEL")) {
					arrCpt[1]++;
				} else if (typeCpt.equals("LIVRETA")) {
					arrCpt[2]++;
				}
			}
		}
		return !(arrCpt[2] < 1 || typeCpt.equals("LIVRETA") || arrCpt[1] > 1 && typeCpt.equals("PEL")
				|| typeCpt.equals("COURANT") && arrCpt[0] > 3);
	}
}
