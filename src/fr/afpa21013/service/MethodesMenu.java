package fr.afpa21013.service;

import java.net.MalformedURLException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import fr.afpa21013.Client;
import fr.afpa21013.utils.Helpers;

public class MethodesMenu {

	AgencyService agServe = AgencyService.getAgencyService();
	ClientService clServe = ClientService.getClientService();
	BankAccountService baServe = BankAccountService.getAccountService();

	public void start() throws AddressException, MessagingException, MalformedURLException {
		displayMenu();
		boolean run = true;
		do {
			String choice = Helpers.getScanner().nextLine();
			switch (choice.toUpperCase()) {
			case "1":
				Helpers.clearScreen();
				agServe.createAgency();
				break;

			case "2":
				Helpers.clearScreen();
				clServe.createClient();
				break;

			case "3":
				Helpers.clearScreen();
				if (ClientService.clients.length > 0 && AgencyService.agencies.length > 0
						&& BankAccountService.bankAccounts.length < 4) {
					baServe.createAccount();
				} else {
					System.out.println(
							"Les conditions de création de comptes ne sont pas respecté : \n-Une agence doit exister. \n-Un client doit exister. \n-Le nombre de compte maximum qu'un client peut possèder est de 3");
				}
				break;

			case "4":
				Helpers.clearScreen();
				baServe.searchAccount();
				break;

			case "5":
				Helpers.clearScreen();
				searchClient();
				break;

			case "6":
				Helpers.clearScreen();
				clServe.displayClientCountList();
				break;

			case "7":
				Helpers.clearScreen();
				System.out.print("Entrez l'identifiant client : ");
				String nameNrCount = Helpers.getScanner().nextLine();
				Client client = clServe.searchClient(nameNrCount, "idCli");
				System.out.println(clServe.dislayClientInfo(client));
				// voulez-vous imprimer
				break;

			case "Q":
				Helpers.clearScreen();
				run = false;
				System.out.println("Fermeture du programme");
				break;

			default:
				Helpers.clearScreen();
				displayMenu();
			}
		} while (run);
	}

	public void displayMenu() {
		System.out.println(
				"------------------------------------------------MENU DE GESTION DE LA BANQUE CDA------------------------------------------------\n");
		System.out.println("1- Créer une agence");
		System.out.println("2- Créer un client");
		System.out.println("3- Créer un compte bancaire");
		System.out.println("4- Rechercher un compte (par numéro de compte)");
		System.out.println("5- Rechercher un client...");
		System.out.println("6- Affichier la liste des commptes d'un client (par identifiant)");
		System.out.println("7- Imprimer les infos d'un client (par identifiant)");
		System.out.println("\nQ- Quitter\n");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------\n");
		System.out.print("Votre choix :");
	}

	public void searchClient() {
		displayMenuClient();
		displayMenu();
	}

	public void displayMenuClient() {
		System.out.println("Choisir selon...\n\n");
		System.out.println("1- Nom du client");
		System.out.println("2- Numero de compte");
		System.out.println("3- Identifiant client");
		System.out.println("4- Retour au menu principal");

		System.out.print("Votre choix :");

		String nameNrCount = "";
		label1: while (true) {
			switch (Helpers.getScanner().nextLine()) {
			case "1":
				Helpers.clearScreen();
				System.out.print("Entrez le nom et le prénom du client (tout attaché) : ");
				nameNrCount = Helpers.getScanner().nextLine();
				System.out.println(clServe.searchClient(nameNrCount, "name"));
				System.out.println("\n(Appuyer sur entrer pour retourner au menu principal)");
				Helpers.getScanner().nextLine();
				break label1;

			case "2":
				Helpers.clearScreen();
				System.out.print("Entrez un numero de compte du client : ");
				nameNrCount = Helpers.getScanner().nextLine();
				System.out.println(clServe.searchClient(nameNrCount, "account"));
				System.out.println("\n(Appuyer sur entrer pour retourner au menu principal)");
				Helpers.getScanner().nextLine();
				break label1;

			case "3":
				Helpers.clearScreen();
				System.out.print("Entrez l'identifiant client : ");
				nameNrCount = Helpers.getScanner().nextLine();
				System.out.println(clServe.searchClient(nameNrCount, "idCli"));
				System.out.println("\n(Appuyer sur entrer pour retourner au menu principal)");
				Helpers.getScanner().nextLine();
				break label1;

			case "4":
				Helpers.clearScreen();
				displayMenu();
				break label1;
			default:
				displayMenuClient();
			}
		}
	}
}
